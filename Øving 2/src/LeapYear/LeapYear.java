package LeapYear;

import java.util.Scanner;

public class LeapYear {
  public static void main() {
    for (int year : LeapYear.testData) {
      LeapYear.checkAndLogLeapYear(year);
    }
  }
  public static void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Skriv inn et årstall");

    int yearString = Integer.parseInt(scanner.nextLine());
    LeapYear.checkAndLogLeapYear(yearString);
    
    // scanner.close();
  }
  public static boolean isLeapYear(int year) {
    if (year % 100 == 0 && year % 400 != 0) return false;
    return year % 4 == 0;
  }
  public static void checkAndLogLeapYear(int year) {
    boolean isLeapYear = LeapYear.isLeapYear(year);
    System.out.println("Året " + year + " er " + (!isLeapYear ? "ikke " : "") + "et skuddår");
  }
  static public int[] testData = {
    2012,
    2013,
    2014,
    2015,
    2016,
    2017,
    2100,
    2400
  };
}