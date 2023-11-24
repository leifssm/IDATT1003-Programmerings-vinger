package NyString;

class NyString {
  private String string;
  public String getString() {
    return string;
  }
  NyString(String string) {
    this.string = string;
  }
  NyString(NyString string) {
    this.string = string.getString();
  }
  public String toString() {
    return string;
  }
  public NyString shorten() {
    String[] words = string.split(" ");
    String shortened = "";
    for (String word : words) {
      shortened += word.charAt(0);
    }
    return new NyString(shortened);
  }
  public NyString remove(char character) {
    String removed = "";
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) != character) {
        removed += string.charAt(i);
      }
    }
    return new NyString(removed);
  }
}