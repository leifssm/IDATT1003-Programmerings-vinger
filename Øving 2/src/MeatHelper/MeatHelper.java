package MeatHelper;

import java.util.Scanner;

public class MeatHelper {
  public static void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hvor mange kjøttpakker vil du sammenlikne?");

    int numberOfMeats = Integer.parseInt(scanner.nextLine());
    MeatPackage[] meatList = new MeatPackage[numberOfMeats];
    
    for (int i = 0; i < numberOfMeats; i++) {
      System.out.println("Hvor mye koster kjøttpakke nr " + (i + 1) + "?");
      float price = Float.parseFloat(scanner.nextLine());
      System.out.println("Hvor mange gram veier kjøttpakke nr " + (i + 1) + "?");
      int weight = Integer.parseInt(scanner.nextLine());
      meatList[i] = new MeatPackage(price, weight);
    }
    final MeatPackage best = MeatHelper.findBest(meatList);
    System.out.println("Den billigste pakken er pakken som koster " + best.price +
      " og veier " + best.weight + "gram til en pris av " + best.pricePerKilo + "kr per kilo"
    );
    scanner.close();
  }
  static MeatPackage findBest(MeatPackage[] list) {
    if (list.length == 0) throw new Error("Cannot find best price of an empty array");
    MeatPackage best = list[0];
    for (int i = 1; i < list.length; i++) {
      MeatPackage meat = list[i];
      if (meat.pricePerKilo < best.pricePerKilo) best = meat;
    }
    return best;
  }
}
