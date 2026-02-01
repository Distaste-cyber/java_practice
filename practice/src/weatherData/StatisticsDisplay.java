import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

  private double avgTemp;
  private double n = 0.0;
  private double Sum;
  private double maxTemp = Double.NEGATIVE_INFINITY;
  private double minTemp = Double.POSITIVE_INFINITY;
  private Observable obs;

  public StatisticsDisplay(Observable obs) {
    this.obs = obs;
    this.obs.addObserver(this);
  }

  public void update(Observable obs, Object obj) {
    if (obs instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) obs;
      double temp = (double) weatherData.getTemprature();
      this.maxTemp = Math.max(temp, maxTemp);
      this.minTemp = Math.min(temp, minTemp);
      this.Sum += temp;
      this.n += 1;
      this.avgTemp = Sum / n;
    }
    this.display();
  }

  public void display() {
    System.out.println(
      "Temprature Statistics Avg/Min/Max: " +
        this.avgTemp +
        " / " +
        this.minTemp +
        " / " +
        this.maxTemp
    );
  }
}
