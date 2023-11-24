package CurrencyCalculator;

import InputParser.InputParser;

public class CurrencyCalculator {
  public static void main(String[] args) {
    Currency[] currencies = {
      new Currency("EUR", 20),
      new Currency("USD", 15),
      new Currency("SEK", 300),

    };

    boolean quit = false;
    while (!quit) {
      System.out.println("Velg verdi");
      for (int i = 0; i < currencies.length; i++) {
        System.out.println((i + 1) + ": " + currencies[i].toString());
      }
      System.out.println((currencies.length + 1) + ": Avslutt");
      int answer = InputParser.getInt("Valg: ", (int value) -> {
        return 1 <= value && value <= currencies.length + 1;
      });
      if (answer == currencies.length + 1) {
        quit = true;
        continue;
      }

      System.out.println("Velg valuta:\n1: dollar\n2: euro\n3: svenske kroner\n4: avslutt");
      int convertionAnswer = InputParser.getInt("Valg: ", (int value) -> {
        return 1 <= value && value <= 4;
      });
      if (convertionAnswer == 4) {
        quit = true;
        break;
      }
      final String currency = switch (convertionAnswer) {
        case 1 -> "USD";
        case 2 -> "EUR";
        case 3 -> "SEK";
        default -> throw new IllegalArgumentException("Unexpected value: " + convertionAnswer);
      };

      Currency selectedCurrency = currencies[answer - 1];
      selectedCurrency.convertToCurrency(currency);
    }
  }
}
