import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

  private float temprature;
  private float humidity;
  private Observable obs;

  public CurrentConditionsDisplay(Observable obs) {
    this.obs = obs;
    obs.addObserver(this);
  }

  public void update(Observable obs, Object obj) {
    if (obs instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) obs;
      this.temprature = weatherData.getTemprature();
      this.humidity = weatherData.getHumidity();
      display();
    }
  }

  public void display() {
    System.out.println(
      "Current Conditions: " +
        temprature +
        "F Degrees and " +
        humidity +
        "% humidity"
    );
  }
}
