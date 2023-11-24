package EventRegister;

import Event.Event;

public class EventRegisterTester {
  public static void main(String[] args) {
    final long date1 = Event.createDateTime(1, 4, 2023, 15, 49);
    final long date2 = Event.createDateTime(15, 8, 2023, 15, 49);
    final long date3 = Event.createDateTime(20, 9, 2023, 15, 49);
    final long date4 = Event.createDateTime(31, 12, 2023, 23, 59);

    EventRegister register = new EventRegister();
    register.addArrangement(new Event("Nyttårsfest",   "Samfunnet", "Ola Arrangør",      "Disco", date4));
    register.addArrangement(new Event(  "Fadderuke",        "NTNU",         "NTNU",   "Hagefest", date3));
    register.addArrangement(new Event(       "Fest",   "Samfunnet",    "Samfunnet",   "Hagefest", date2));
    register.addArrangement(new Event(       "Fest",        "NTNU",         "NTNU",      "Disco", date4));
    register.addArrangement(new Event(   "Matpause",      "Maccis",    "Fadderbe",        "Mat", date1));
    register.addArrangement(new Event(   "Matpause",      "Maccis",    "Fadderbe",        "Mat", date2));
    register.addArrangement(new Event(   "Matpause",      "Maccis",    "Fadderbe",        "Mat", date3));
    register.addArrangement(new Event(       "Fest",   "Samfunnet",    "Fadderbe",        "Mat", date3));
    register.addArrangement(new Event(       "Fest",        "NTNU",         "NTNU", "Hjemmefest", date1));
    register.addArrangement(new Event(       "Fest",        "NTNU",         "NTNU", "Hjemmefest", date4));
    System.out.println(register.getLength());
    System.out.println("--Alle arrangementer på Samfunnet--");
    EventRegister.log(register.getEventsAtPlace("Samfunnet"));
    System.out.println("\n--Alle arrangementer på den 20. august 2023--");
    EventRegister.log(register.getEventsAtTime(date3));
    System.out.println("\n--Alle arrangementer mellom den 15. august 2023 og 31. desember 2023--");
    EventRegister.log(register.getEventsBetween(date2, date4));
  }
}
