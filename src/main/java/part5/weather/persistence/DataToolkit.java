package part5.weather.persistence;

import part5.weather.wmsdata.HiLoData;
import part5.weather.wmsdata.NoSuchDateException;
import java.util.Date;

public class DataToolkit implements part5.weather.wmsdata.DataToolkit
{
  final private String temperatureKey = "Temp";

  public HiLoData getTempHiLoData(Date aDate) throws NoSuchDateException
  {
    return new HiLoProxy(temperatureKey, aDate);
  }

  public HiLoData getTempHiLoData(Date aDate, double initialValue) 
  {
    return new HiLoProxy(temperatureKey, aDate, initialValue);
  }
}
