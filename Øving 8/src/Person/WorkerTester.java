import InputParser.InputParser;

public class WorkerTester {
  public static void main(String[] args) {
    Person person = new Person("Ola", "Nordmann", 40);
    Worker worker = new Worker(person, 123, 2015, 42000, 0.2f);
    logWorker(worker);
    while (true) {
      System.out.println("\nEndre " + worker.getFullName() + ":\n1: Lønn\n2: Skattesats\n3: Avslutt");
      int choice = InputParser.getInt("Valg:", (int n) -> { return n > 0 && n < 4; } );
      System.out.println();
      switch (choice) {
        case 1:
          int newSalary = InputParser.getInt("Ny lønn:", (int l) -> { return l >= 0; });
          testSalary(worker, newSalary);
          break;
        case 2:
          float newTaxRate = InputParser.getFloat("Ny skattesats:", (float t) -> { return t >= 0 && t <= 1; });
          testTaxRate(worker, newTaxRate);
          break;
        case 3:
          System.exit(0);
        default:
          break;
      }
    }
  }
  public static void logWorker(Worker worker) {
    System.out.println("Navn: " + worker.getFullName());
    System.out.println("Alder: " + worker.getAge());
    System.out.println("Senjoritet: " + worker.getWorkerSeniority());
    System.out.println("Har jobbet lengre enn 5 år: " + worker.hasWorkedLongerThan(5));
    System.out.println("Har jobbet lengre enn 10 år: " + worker.hasWorkedLongerThan(10));
    logWorkerSalary(worker);
  }
  public static void logWorkerSalary(Worker worker) {
    System.out.println("Årlig bruttolønn: " + worker.getYearlyGrossSalary());
    System.out.println("Totalt skatt i året: " + worker.getYearlyTaxAmount());
    System.out.println("Årlig nettolønn: " + worker.getYearlyNetSalary());
    System.out.println("Skatt for februar:" + worker.getTaxRateForMonth(2));
    System.out.println("Skatt for juni:" + worker.getTaxRateForMonth(6));
    System.out.println("Skatt for desember:" + worker.getTaxRateForMonth(12));
  }
  public static void testSalary(Worker worker, int newSalary) {
    worker.setSalary(newSalary);
    assertEquals("Lønn", newSalary, worker.getSalary());
    logWorkerSalary(worker);
  }
  public static void testTaxRate(Worker worker, float newTaxRate) {
    worker.setTaxRate(newTaxRate);
    assertEquals("Skattesats", newTaxRate, worker.getTaxRate());
    logWorkerSalary(worker);
  }

  public static void assertEquals(String info, double expected, double actual) {
    if (expected == actual) {
      System.out.println(info + " test passed");
    } else {
      System.out.println(info + " test failed: expected " + expected + " but got " + actual);
    }
  }
}
