public class WeatherStation {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();

    CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
      weatherData
    );

    StatisticsDisplay stats = new StatisticsDisplay(weatherData);

    HeatIndexDisplay hiD = new HeatIndexDisplay(weatherData);

    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setMeasurements(80.0f, 65.0f, 34.0f);
    weatherData.setMeasurements(82.0f, 70.0f, 29.2f);
    weatherData.setMeasurements(78.0f, 90.0f, 29.2f);
  }
}
