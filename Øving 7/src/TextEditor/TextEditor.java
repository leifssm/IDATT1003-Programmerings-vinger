package TextEditor;

public class TextEditor {
  private String string;
  public String getString() {
    return string;
  }
  public String toString() {
    return string;
  }
  TextEditor(String string) {
    this.string = string;
  }
  public int getWordCount() {
    return string.split(" ").length;
  }
  public double getAverageWordLength() {
    String[] words = string.split(" ");
    int totalLength = 0;
    for (String word : words) {
      totalLength += word.length();
    }
    return ((double) totalLength) / words.length;
  }
  public double getAverageSentenceLength() {
    String[] sentences = string.split("[:.!?]");
    int totalLength = 0;
    for (String sentence : sentences) {
      totalLength += sentence.split(" ").length;
    }
    return ((double) totalLength) / sentences.length;
  }
  public TextEditor replaceWordWith(String word, String replacement) {
    return new TextEditor(string.replaceAll(word, replacement));
  }
  public TextEditor capitalize() {
    return new TextEditor(string.toUpperCase());
  }
}
