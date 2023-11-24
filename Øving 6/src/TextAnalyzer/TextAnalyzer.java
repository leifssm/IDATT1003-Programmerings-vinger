package TextAnalyzer;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import InputParser.InputParser;

public class TextAnalyzer {
  public static void main(String[] args) {
    while (true) {
      System.out.println("Skriv en tekst å analysere, en tom string avslutter programmet.");

      String input = InputParser.getString("Tekst:");
      char[] chars = input.toCharArray();

      if (input.length() == 0) break;
      System.out.println(chars);

      final int[] sortedChars = new int[30];
      for (char c : chars) {
        final int id = charToInt(c);
        sortedChars[id]++;
      }
      boolean newString = false;
      while (!newString) {
        System.out.println(
          "Setning: " + input + "\n" +
          "Velg analyse:\n" +
          "1. Finn antall forskjellige bokstaver\n" +
          "2. Få antall bokstaver\n" +
          "3. Hvor stor prosent er tegn?\n" +
          "4. Finn antall av en bestemt bokstav.\n" + 
          "5. Hvilket tegn brukes oftest?"
        );
        final int option = InputParser.getInt("Valg:", (int n) -> { return n >= 1 && n <= 6; });
        System.out.println();
        switch (option) {
          case 1: {
            final int result = getDifferentChars(sortedChars);
            System.out.println("Det er " + result + " forskjellige tegn.");
            break;
          }
          case 2: {
            final int result = getTotalChars(sortedChars);
            System.out.println("Det er " + result + " bokstaver i teksten.");
            break;
          }
          case 3: {
            final String result = getCharPercentage(sortedChars);
            System.out.println("Det er " + result + " bokstaver");
            break;
          }
          case 4: {
            final char character = InputParser.getChar("Velg bokstav å lete etter");
            final int result = searchChar(sortedChars, character);
            System.out.println("Det er " + result + " av tegnet " + character);
            break;
          }
          case 5: {
            final List<String> result = getMostUsed(sortedChars);
            System.out.println("De mest brukte tegna er " + result);
            break;
          }
          default: {
            newString = true;
            break;
          }
        }
        System.out.println();
      }
    }
  }
  static int getDifferentChars(int[] array) {
    int total = 0;
    for (int n = 0; n < array.length - 1; n++) if (array[n] > 0) total++;
    return total;
  }
  static int getTotalChars(int[] array) {
    int total = 0;
    for (int i = 0; i < array.length - 1; i++) total += array[i];
    return total;
  }
  static String getCharPercentage(int[] array) {
    final int totalChars = getTotalChars(array);
    double percentage = Math.floor(1000 * totalChars / (totalChars + array[array.length - 1])) / 10;
    return Double.toString(percentage) + "%";
  }
  static int searchChar(int[] array, char character) {
    final int id = charToInt(character);
    return array[id];
  }
  static List<String> getMostUsed(int[] array) {
    int max = 0;
    List<String> list = new ArrayList<String>();

    for (int i = 0; i < array.length; i++) {
      final int count = array[i];
      if (count == 0) continue;
      if (count > max) {
        list.clear();
        list.add(intToString(i));
        max = count;
        continue;
      }
      if (count == max) list.add(intToString(i));
    }

    return list;
  }
  static String intToString(int number) {
    String chars = "abcdefghijklmnopqrstuvwxyzæøå-";
    if (number < 0 || number >= chars.length()) return chars.substring(chars.length() - 1, chars.length());
    return chars.substring(number, number + 1);
  }
  static int charToInt(char character) {
    int ascii = Character.toLowerCase(character);
    switch (ascii) {
      case 230:
        ascii = 26;
        break;
      case 248:
        ascii = 27;
        break;
      case 229:
        ascii = 28;
        break;
      default:
        ascii -= 97;
        if (ascii < 0 || ascii > 25) ascii = 29; 
        break;
    }
    return ascii;
  }
}
