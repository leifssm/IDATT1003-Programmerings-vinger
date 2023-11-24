package Event;

class EventTester {
  public static void main(String[] args) {
    assertEquals(Event.createDateTime(23, 8, 2023), 202308230000L);
    assertEquals(Event.createDateTime(23, 8, 2023, 14, 56), 202308231456L);

    Event event1 = new Event("Nyttårsfest", "Samfunnet", "Ola", "Disco", 202308231456L);
    Event event2 = new Event("Fadderfest", "NTNU", "Fadderne", "Hagefest", 202309231456L);
    assertEquals(event1.getDateTimeString(), "14:56 23/08/2023");
    assertEquals(event2.toString(), "Arrangement \"Fadderfest\" av Fadderne på NTNU kl 14:56 23/09/2023 (Hagefest)");
    assertTrue(Event.isBefore(event1, event2));
    assertTrue(event1.isOnDate(202308231203L));
    assertTrue(event2.isBetweenDates(202309231203L, 202309231456L));
    assertTrue(Event.sorterShouldSwitch(event1, event2));
  }
  public static void assertTrue(boolean result) {
    if (result) {
      System.out.println("Test passed");
    } else {
      System.out.println("Test failed: Expected \"true\" but got \"false\"");
    }
  }
  public static void assertEquals(long actual, long expected) {
    if (expected == actual) {
      System.out.println("Test passed, got \"" + actual + "L\"");
    } else {
      System.out.println("Test failed: Expected \"" + expected + "L\", got \"" + actual + "L\"");
    }
  }
  public static void assertEquals(String actual, String expected) {
    if (expected.equals(actual)) {
      System.out.println("Test passed, got \"" + actual + "\"");
    } else {
      System.out.println("Test failed: Expected \"" + expected + "\", got \"" + actual + "\"");
    }
  }
}
