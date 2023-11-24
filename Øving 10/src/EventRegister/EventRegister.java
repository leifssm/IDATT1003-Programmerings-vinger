package EventRegister;

import java.util.ArrayList;

import Event.Event;


  // use streams

public class EventRegister {

  // change to list
  private final ArrayList<Event> events = new ArrayList<>();
  private int length = 0;

  public EventRegister() {}
  public EventRegister(ArrayList<Event> events) {
    for (Event event : events) {
      addArrangement(event);
      // change to addArrangement(new Event())
    }
  }
  public void addArrangement(Event student) {
    events.add(student);
    length++;
  }
  public int getLength() {
    return length;
  }
  public ArrayList<Event> getEventsAtPlace(String place) {
    ArrayList<Event> matchingEvents = new ArrayList<Event>();
    for (Event event : events) {
      if (event.getPlace().equals(place)) {
        matchingEvents.add(event);
      }
    }
    return matchingEvents;
  }
  public ArrayList<Event> getEventsAtTime(long date) {
    ArrayList<Event> matchingEvents = new ArrayList<Event>();
    for (Event event : events) {
      if (event.isOnDate(date)) {
        matchingEvents.add(event);
      }
    }
    return matchingEvents;
  }
  public ArrayList<Event> getEventsBetween(long date1, long date2) {
    ArrayList<Event> matchingEvents = new ArrayList<Event>();
    for (Event event : events) {
      if (event.isBetweenDates(date1, date2)) {
        matchingEvents.add(event);
      }
    }
    return EventRegister.sortEvents(matchingEvents);
  }
  static private ArrayList<Event> sortEvents(ArrayList<Event> events) {
    ArrayList<Event> sortedEvents = new ArrayList<Event>();
    for (Event event : events) {
      boolean added = false;
      for (int i = 0; i < sortedEvents.size(); i++) {
        if (Event.sorterShouldSwitch(event, sortedEvents.get(i))) {
          sortedEvents.add(i, event);
          added = true;
          break;
        }
      }
      if (!added) {
        sortedEvents.add(event);
      }
    }
    return sortedEvents;
  }
  public ArrayList<Event> getEvents() {
    return EventRegister.sortEvents(events);
  }
  public static void log(ArrayList<Event> list) {
    for (Event event : list) {
      System.out.println(event);
    }
  }
}
