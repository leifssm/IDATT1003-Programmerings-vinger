package FractionCalculator;

import InputParser.InputParser;

public class FractionCalculator {
  public static void main(String[] args) {
    int a, b;
    System.out.println("Lag første brøk: ■/-");
    a = InputParser.getInt("Heltall: ");
    System.out.println("Lag første brøk: " + a + "/■");
    b = InputParser.getInt("Heltall: ");
    final Fraction fraction1 = new Fraction(a, b);

    System.out.println("Lag andre brøk: ■/-");
    a = InputParser.getInt("Heltall: ");
    System.out.println("Lag andre brøk: " + a + "/■");
    b = InputParser.getInt("Heltall: ");
    final Fraction fraction2 = new Fraction(a, b);

    System.out.println("Velg operasjon:\n  " + fraction1 + " ■ "  + fraction2 + "\n\n1. +\n2. -\n3. *\n4. /");
    final int operation = InputParser.getInt("Operasjon: ", (int answer) -> 1 <= answer && answer <= 4);

    switch (operation) {
      case 1:
        fraction1.add(fraction2);
        break;
      case 2:
        fraction1.subtract(fraction2);
        break;
      case 3:
        fraction1.multiply(fraction2);
        break;
      case 4:
        fraction1.divide(fraction2);
        break;
    }
    System.out.println("Result: " + fraction1 + "\n\n");
  }
}
