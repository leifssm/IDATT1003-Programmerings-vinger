package Student;

public class Student {
  private final String name;
  private int confirmedTasks;
  public Student(String name, int confirmedTasks) {
    this.name = name;
    this.confirmedTasks = confirmedTasks;
  }
  public String getName() {
    return name;
  }
  public int getConfirmedTasks() {
    return confirmedTasks;
  }
  public void increaseConfirmedTasks(int increase) {
    if (0 < increase) confirmedTasks += increase;
  }
  public String toString() {
    return name + " har " + confirmedTasks + " godkjente oppgaver.";
  }
}