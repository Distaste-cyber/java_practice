import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements DisplayElement, Observer {

  private float temprature;
  private float humidity;
  private Observable obs;
  private float heatIndex;

  public HeatIndexDisplay(Observable obs) {
    this.obs = obs;
    this.obs.addObserver(this);
  }

  public void update(Observable obs, Object obj) {
    if (obs instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) obs;
      this.temprature = weatherData.getTemprature();
      this.humidity = weatherData.getHumidity();

      this.heatIndex = this.computeHeatIndex(this.temprature, this.humidity);
      this.display();
    }
  }

  public void display() {
    System.out.println("Heat Index is: " + this.heatIndex);
  }

  private float computeHeatIndex(float t, float rh) {
    float index = (float) ((16.923 +
        (0.185212 * t) +
        (5.37941 * rh) -
        (0.100254 * t * rh) +
        (0.00941695 * (t * t)) +
        (0.00728898 * (rh * rh)) +
        (0.000345372 * (t * t * rh)) -
        (0.000814971 * (t * rh * rh)) +
        (0.0000102102 * (t * t * rh * rh)) -
        (0.000038646 * (t * t * t)) +
        (0.0000291583 * (rh * rh * rh)) +
        (0.00000142721 * (t * t * t * rh)) +
        (0.000000197483 * (t * rh * rh * rh)) -
        (0.0000000218429 * (t * t * t * rh * rh)) +
        0.000000000843296 * (t * t * rh * rh * rh)) -
      (0.0000000000481975 * (t * t * t * rh * rh * rh)));
    return index;
  }
}
