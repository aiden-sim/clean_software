package part5.weather.persistence;

public class Scope
{
  public static void init()
  {
    part5.weather.wmsdata.Scope.itsDataToolkit = new DataToolkit();
  }
}
