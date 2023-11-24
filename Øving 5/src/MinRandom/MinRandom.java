package MinRandom;

import java.util.Random;

public class MinRandom {
  public static void main(String[] args) {
    final MinRandom r = new MinRandom();
    for (int i = 0; i < 15; i++) {
      System.out.println(r.nesteHeltall(1, 4));
    }
    System.out.println("----");
    for (int i = 0; i < 15; i++) {
      System.out.println(r.nesteDesimaltall(1, 4));
    }
  }
  private Random generator = new Random();
  public int nesteHeltall(int nedre, int ovre) {
    return (int) Math.floor(generator.nextDouble() * (ovre - nedre + 1)) + nedre;
  }
  public double nesteDesimaltall(double nedre, double ovre) {
    return generator.nextDouble() * (ovre - nedre + 1) + nedre;
  }
}
