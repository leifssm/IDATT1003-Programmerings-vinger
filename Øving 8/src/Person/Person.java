class Person {
  private final String firstname;
  private final String lastname;
  private final int age;

  public String getFirstName() {
    return this.firstname;
  }
  public String getLastName() {
    return this.lastname;
  }
  public int getAge() {
    return age;
  }
  public Person(String firstname, String lastname, int age) {
    this.firstname = firstname;
    this.lastname = lastname; 
    this.age = age;
  }
}
