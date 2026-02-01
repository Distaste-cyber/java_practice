import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

  private float currentPressure = 29.92f;
  private float lastPressure;
  private Observable obs;

  public ForecastDisplay(Observable obs) {
    this.obs = obs;
    this.obs.addObserver(this);
  }

  public void update(Observable obs, Object obj) {
    if (obs instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) obs;
      this.lastPressure = this.currentPressure;
      this.currentPressure = weatherData.getPressure();
      display();
    }
  }

  public void display() {
    System.out.println(
      "I Don't know how to do forecasts, Here is the pressure: " +
        this.currentPressure
    );
  }
}
