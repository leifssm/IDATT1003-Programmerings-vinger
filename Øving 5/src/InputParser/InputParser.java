package InputParser;

import java.util.Scanner;

public class InputParser {
  static Scanner scanner;
  static void initialize() {
    if (scanner != null) return;
    scanner = new Scanner(System.in);
  }
  public static void close() {
    if (InputParser.scanner == null) return;
    scanner.close();
    scanner = null;
  }
  public static int getInt(String prompt, IntegerInputValidator validator) {
    int result;
    boolean validated = false;
    do {
      result = getInt(prompt);
      validated = validator.test(result);
    } while(!validated);
    return result;
  }
  public static int getInt(String prompt) {
    initialize();
    int output = 0;
    boolean finished = false;
    do {
      System.out.print(prompt);
      String input = scanner.nextLine();
      try {
        output = Integer.parseInt(input);
        finished = true;
      } catch (Exception e) {};
    } while (!finished);
    return output;
  }
  public static String getString(String prompt) {
    initialize();
    System.out.print(prompt);
    String output = scanner.nextLine();
    return output;
  }
}