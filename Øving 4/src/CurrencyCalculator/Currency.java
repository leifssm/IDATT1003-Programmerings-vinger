package CurrencyCalculator;

import java.util.Map;

public class Currency {
  String type;
  float value;
  Currency(String currency, float value) {
    this.type = currency;
    this.value = value;
  }
  public void convertToCurrency(String currency) {
    if (this.type == currency) return;
    Float convertionToNok = convertions.get(this.type);
    Float convertionToNew = convertions.get(currency);

    if (convertionToNew == null) return;
    this.value *= convertionToNew;
    this.value /= convertionToNok;
    this.type = currency;
  }
  public String toString() {
    return this.value + " " + this.type;
  }
  static Map<String, Float> convertions = Map.of(
    "NOK", 1.0f,
    "USD", 0.093f,
    "EUR", 0.087f,
    "SEK", 1.04f
  );
}