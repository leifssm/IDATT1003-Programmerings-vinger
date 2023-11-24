package TextEditor;

public class TextEditorTester {
  public static void main(String[] args) {
    TextEditor string = new TextEditor("Dette er en test. Dette er en annen test. Den har mange setninger.");
    System.out.println(string);
    System.out.println(string.getWordCount());
    System.out.println(string.getAverageWordLength());
    System.out.println(string.getAverageSentenceLength());
    System.out.println(string.replaceWordWith("test", "setning"));
    System.out.println(string.capitalize());
  }
}
