package part5.weather.system;

import java.util.Observer;

import part5.weather.api.StationToolkit;

public class WeatherStation implements
        part5.weather.component.WeatherStationComponent
{
  private TemperatureSensor ts;
  private BarometricPressureSensor bps;
  private TempHiLo itsTempHiLo;

  public WeatherStation(String toolkit) throws Exception
  {
    Class classFor = Class.forName(toolkit); // Nimbus 1.0 등...
    StationToolkit st = (StationToolkit)classFor.newInstance();
    part5.weather.api.Scope.stationToolkit = st;

    AlarmClock ac = new AlarmClock(st);

    // create the sensors
    ts = new TemperatureSensor(ac, st);
    // create the sensors
    bps = new BarometricPressureSensor(ac, st);

    // create the historical sensors
    itsTempHiLo = new TempHiLo(ac, ts);
  }

  public void addTempObserver(Observer o)
  {
    ts.addObserver(o);
  }

  public void addBPObserver(Observer o)
  {
    bps.addObserver(o);
  }
}
