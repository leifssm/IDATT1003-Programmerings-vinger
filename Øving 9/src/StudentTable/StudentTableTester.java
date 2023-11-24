package StudentTable;

import Student.Student;

public class StudentTableTester {
  public static void main(String[] args) {
    StudentTable st = new StudentTable();
    st.addStudent(new Student("Ola", 3));
    try {
      st.addStudent(new Student("Ola", 10));
      System.out.println("[!] Check feilet");
    } catch (Exception e) {
      System.out.println("Check fungerte");
    }
    st.addStudent(new Student("Kari", 5));
    System.out.println(st);
    st.increaseConfirmedTasks("Ola", 2);
    st.increaseConfirmedTasks("Kari", -1);
    System.out.println(st);
  }
}
