package part5.weather.wmsdata;

public class NoSuchDateException extends Exception
{
  public NoSuchDateException(String key)
  {
    super("No object named \\" + key + "\" found");
  }
}

