import java.util.Calendar;
import java.util.GregorianCalendar;

public class Worker {
  private final Person personalia;
  private final int workerId;
  private final int employmentYear;
  private int salary;
  private float taxRate;

  public int getWorkerId() {
    return workerId;
  }
  public int getEmploymentYear() {
    return employmentYear;
  }
  public int getSalary() {
    return salary;
  }
  public float getTaxRate() {
    return taxRate;
  }
  public void setSalary(int salary) {
    this.salary = salary;
  }
  public void setTaxRate(float taxRate) {
    this.taxRate = taxRate;
  }
  public Worker(Person personalia, int workerId, int employmentYear, int salary, float taxRate) {
    this.personalia = personalia;
    this.workerId = workerId;
    this.employmentYear = employmentYear;
    this.salary = salary;
    this.taxRate = taxRate;
  }
  public String getFullName() {
    return personalia.getLastName() + ", " + personalia.getFirstName();
  }
  public int getAge() {
    return personalia.getAge();
  }
  public int getWorkerSeniority() {
    GregorianCalendar calender = new GregorianCalendar();
    int year = calender.get(Calendar.YEAR);
    return year - employmentYear;
  }
  public boolean hasWorkedLongerThan(int years) {
    return getWorkerSeniority() > years;
  }
  public int getYearlyGrossSalary() {
    return salary * 12;
  }
  public float getTaxRateForMonth(int monthNumber) {
    if (monthNumber == 6) return taxRate / 2;
    if (monthNumber == 12) return 0;
    return taxRate;
  }
  public float getYearlyTaxAmount() {
    float netTax = 0;
    for (int i = 1; i <= 12; i++) {
      netTax += getTaxRateForMonth(i) * salary;
    }
    return netTax;
  }
  public float getYearlyNetSalary() {
    return getYearlyGrossSalary() - getYearlyTaxAmount();
  }
}
