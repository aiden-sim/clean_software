package part5.weather.system;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import part5.weather.api.StationToolkit;
import part5.weather.api.ClockListener;
import part5.weather.api.AlarmClockImp;

/**
 * 
 * @see AlarmListener
 * @version 1.0
 */

public class AlarmClock
{
  private AlarmClockImp itsImp;
  private HashMap itsListeners;

  private void clockPulse()
  {
    // This will be called every 10ms.

    // determine if anyone registered needs to be 
    // informed
  }

  public AlarmClock(StationToolkit st)
  {
    itsImp = st.getAlarmClock();

    ClockListener cl = new ClockListener()
    {
      public void tic()
      {
        clockPulse();
      }
    };
    itsImp.register(cl);

    itsListeners = new HashMap();
  }

  /** 
   * register to be notified every period.  The value passed 
   * in is in milleseconds.
   **/ 
  public void wakeEvery(long period, AlarmListener al)
  {
    itsListeners.put(al, new Long(period));
  }

  public void wakeUp() {
    Iterator<String> keys = itsListeners.keySet().iterator();
    while (keys.hasNext()) {
      String key = keys.next();
      AlarmListener listner = (AlarmListener)itsListeners.get(key);
      listner.wakeUp();
    }
  }

  /**
   * register to be notified every hour on the hour
   */
  public void wakeEveryHour(AlarmListener al)
  {
  }

  /** 
   * register to be notified every day at midnight 
   **/
  public void wakeEveryDay(AlarmListener al)
  {
  }
}
