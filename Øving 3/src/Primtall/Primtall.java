package Primtall;

import InputParser.InputParser;

public class Primtall {
  public static void main(String[] arg) {
    while (true) {
      int number = InputParser.getInt("Sjekk om tallet er et primtall:");
      boolean prime = isPrime(number);
      System.out.println("Tallet " + number + " er " + (prime ? "" : "ikke ") + "et primtall");
    }
  }
  static boolean isPrime(int number) {
    if (number < 3) return false;
    int squareRoot = (int) Math.sqrt(number);
    for (int i = 2; i <= squareRoot; i++) {
      if (number % i == 0) return false;
    }
    return true;
  }
}
