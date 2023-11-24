package Student;

class StudentTester {
  public static void main(String[] args) {
    Student s1 = new Student("Ola", 3);
    Student s2 = new Student("Kari", 5);
    System.out.println(s1);
    System.out.println(s2);
    s1.increaseConfirmedTasks(2);
    s2.increaseConfirmedTasks(-1);
    System.out.println(s1);
    System.out.println(s2);
  }
}
