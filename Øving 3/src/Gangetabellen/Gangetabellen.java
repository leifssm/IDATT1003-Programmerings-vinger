package Gangetabellen;

import InputParser.InputParser;

public class Gangetabellen {
  public static void main(String[] args) {
    System.out.println("Nå skal vi lære gangetabellen! Hvilke gangetabeller vil du skrive ut?");
    final int from = InputParser.getInt("Fra:");
    System.out.println("Hvilke gangetabeller vil du skrive ut?");
    final int to = InputParser.getInt("Til:");
    final int min = Math.min(from, to);
    final int max = Math.max(from, to);
    for (int i = min; i <= max; i++) {
      System.out.println(i + "-gangen:");
      for (int j = 1; j <= 10; j++) {
        System.out.println(i + " x " + j + " = " + i * j);
      }
    }
  } 
}
