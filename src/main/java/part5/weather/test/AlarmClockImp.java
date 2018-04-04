package part5.weather.test;

import part5.weather.api.ClockListener;

public class AlarmClockImp implements part5.weather.api.AlarmClockImp
{
  public void register(ClockListener aListener)
  {
    new Timer(10, aListener).start();
  }
}
