import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    int likes = 4035;
    int dislikes = 4035;
    double ratio = MathUtils.ratio(likes, dislikes);
    System.out.println("Ratio: " + ratio + "%");
  }
}
