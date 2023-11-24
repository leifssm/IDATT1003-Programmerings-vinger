package NyString;

public class NyStringTester {
  public static void main(String[] args) {
    NyString string = new NyString("Hello, big world!");
    System.out.println(string);
    System.out.println(string.shorten());
    System.out.println(string.remove('l'));
  }
}
