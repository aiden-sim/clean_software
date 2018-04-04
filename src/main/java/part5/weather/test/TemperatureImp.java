package part5.weather.test;

class TemperatureImp implements part5.weather.api.TemperatureSensorImp
{
  private static int value = 0;

  public double read()
  {
    return ++value;
  }
}
