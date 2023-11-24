package Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event {
  private final String name;
  private final String place;
  private final String arranger;
  private final String type;
  private final long dateTime;
  public Event(String name, String place, String arranger, String type, long dateTime) {
    this.name = name;
    this.place = place;
    this.arranger = arranger;
    this.type = type;
    this.dateTime = dateTime;
  }
  public String getName() {
    return name;
  }
  public String getArranger() {
    return arranger;
  }
  public long getDateTime() {
    return dateTime;
  }
  public String getDateTimeString() {
    Pattern regex = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})");
    Matcher date = regex.matcher(Long.toString(dateTime));
    if (!date.find()) {
      return "Ugyldig dato";
    }
    return date.group(4) + ":" + date.group(5) + " " + date.group(3) + "/" + date.group(2) + "/" + date.group(1);
  }
  public String getPlace() {
    return place;
  }
  public String getType() {
    return type;
  }
  public String toString() {
    return "Arrangement \"" + name + "\" av " + arranger + " på " + place + " kl " + getDateTimeString() + " (" + type + ")";
  }
  static boolean isBefore(Event event1, Event event2) {
    return event1.dateTime < event2.dateTime;
  }
  public boolean isOnDate(long date) {
    return dateTime / 10000 == date / 10000;
  }
  public boolean isBetweenDates(long date1, long date2) {
    final boolean isAfter = dateTime / 10000 >= date1 / 10000;
    final boolean isBefore = dateTime / 10000 <= date2 / 10000;

    return isAfter && isBefore;
  }

  public static boolean sorterShouldSwitch(Event event1, Event event2) {
    // convert to equals
    final int placeComparison = event1.getPlace().compareTo(event2.getPlace());
    if (placeComparison != 0) return placeComparison > 0;

    final int typeComparison = event1.getType().compareTo(event2.getType());
    if (typeComparison != 0) return typeComparison < 0;
    
    return event1.getDateTime() < event2.getDateTime();
  }

  private static String pad(String number) {
    return number.length() < 2 ? "0" + number : number;
  }
  public static long createDateTime(int day, int month, int year) {
    return Long.parseLong(
      Event.pad(Integer.toString(year)) +
      Event.pad(Integer.toString(month)) +
      Event.pad(Integer.toString(day)) +
      "0000"
    );
  }
  public static long createDateTime(int day, int month, int year, int hour, int minute) {
    return Long.parseLong(
      Event.pad(
        Integer.toString(year) +
        Event.pad(Integer.toString(month)) +
        Event.pad(Integer.toString(day)) +
        Event.pad(Integer.toString(hour)) +
        Event.pad(Integer.toString(minute))
      )
    );
  }
}