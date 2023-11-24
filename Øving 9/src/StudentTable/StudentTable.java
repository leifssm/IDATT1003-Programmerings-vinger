package StudentTable;

import Student.Student;

public class StudentTable {

  private Student[] students;
  private int length = 0; // økes med 1 for hver ny student

  public StudentTable(Student ...students) {
    this.students = new Student[10];
    for (Student student : students) {
      addStudent(student);
    }
  }
  public void addStudent(Student student) {
    if (getStudent(student.getName()) != null) throw new IllegalArgumentException("Studenten finnes allerede i tabellen.");
    if (length >= students.length) {
      Student[] newStudentArray = new Student[length + 10];
      for (int i = 0; i < length; i++) {
        newStudentArray[i] = students[i];
      }
      students = newStudentArray;
    }
    students[length] = student;
    length++;
  }
  public int getLength() {
    return length;
  }
  private Student getStudent(String name) {
    for (int i = 0; i < length; i++) {
      Student student = students[i];
      if (student.getName() == name) {
        return student;
      }
    }
    return null;
  }
  public void increaseConfirmedTasks(String name, int increase) {
    Student student = getStudent(name);
    student.increaseConfirmedTasks(increase);
  }
  public int getConfirmedTasks(String name) {
    Student student = getStudent(name);
    return student.getConfirmedTasks();
  }
  public String toString() {
    String output = "---- Tabell ----";
    for (int i = 0; i < length; i++) {
      output += "\n" + students[i];
    }
    output += "\n----------------";
    return output;
  }
}
