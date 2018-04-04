package part5.weather;

import java.util.Observer;
import java.util.Observable;

import part5.weather.api.StationToolkit;
import part5.weather.system.WeatherStation;
import part5.weather.ui.MonitoringScreen;

class Main 
{
  public static void main(String[] args)
  {
    try
    {
      part5.weather.persistence.Scope.init();

      WeatherStation ws = new WeatherStation(args[0]);
      MonitoringScreen ms = new MonitoringScreen(ws);
      for(;;) 
      {
        // loop forever
      }
    }
    catch(Exception e)
    {
      System.err.println(args[0] + " Invalid Toolkit");
    }
  }
}
