package part5.weather.test;

import part5.weather.api.*;

public class Toolkit implements StationToolkit
{
  private static AlarmClockImp itsClockImp = new part5.weather.test.AlarmClockImp();
  private static PersistentImp itsPersistentImp = new PersistentImp();

  public part5.weather.api.PersistentImp getPersistentImp()
  {
    return itsPersistentImp;
  }

  public part5.weather.api.AlarmClockImp getAlarmClock()
  {
    return itsClockImp;
  }

  public part5.weather.api.TemperatureSensorImp makeTemperature()
  {
    return new part5.weather.test.TemperatureImp();
  }

  public part5.weather.api.BarometricPressureSensorImp makeBarometricPressure()
  {
    return new part5.weather.test.BarometricPressureImp();
  }
}

