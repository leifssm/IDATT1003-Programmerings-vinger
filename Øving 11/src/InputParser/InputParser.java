package InputParser;

import java.util.Scanner;

public class InputParser {
  static Scanner scanner;
  static void initialize() {
    if (scanner != null) return;
    scanner = new Scanner(System.in, "utf-8");
  }
  public static void close() {
    if (InputParser.scanner == null) return;
    scanner.close();
    scanner = null;
  }
  public static int getInt(String prompt, IntegerInputValidator validator) {
    int result;
    while (true) {
      result = getInt(prompt);
      if (validator.test(result)) return result; 
    }
  }
  public static int getInt(String prompt) {
    initialize();
    int result = 0;
    String input;
    while (true) {
      System.out.print(prompt);
      input = scanner.nextLine();
      try {
        result = Integer.parseInt(input);
        return result;
      } catch (Exception e) {};
    }
  }
  public static float getFloat(String prompt, FloatInputValidator validator) {
    float result;
    while (true) {
      result = getFloat(prompt);
      if (validator.test(result)) return result; 
    }
  }
  public static float getFloat(String prompt) {
    initialize();
    String input;
    while (true) {
      System.out.print(prompt);
      input = scanner.nextLine();
      try {
        return Float.parseFloat(input);
      } catch (Exception e) {};
    }
  }
  public static double getDouble(String prompt, DoubleInputValidator validator) {
    double result;
    while (true) {
      result = getFloat(prompt);
      if (validator.test(result)) return result; 
    }
  }
  public static double getDouble(String prompt) {
    initialize();
    String input;
    while (true) {
      System.out.print(prompt);
      input = scanner.nextLine();
      try {
        return Double.parseDouble(input);
      } catch (Exception e) {};
    }
  }
  public static String getString(String prompt, StringInputValidator validator) {
    String result;
    while (true) {
      result = getString(prompt);
      if (validator.test(result)) return result; 
    }
  }
  public static String getString(String prompt) {
    initialize();
    System.out.print(prompt);
    String output = scanner.nextLine();
    return output;
  }
  public static char getChar(String prompt) {
    initialize();
    String input;
    while (true) {
      System.out.print(prompt);
      input = scanner.nextLine();
      if (input.length() == 1) return input.charAt(0);
    }
  }
}