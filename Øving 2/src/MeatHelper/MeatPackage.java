package MeatHelper;

public class MeatPackage {
  float price;
  int weight;
  float pricePerKilo;
  MeatPackage(float price, int weight) {
    this.price = price;
    this.weight = weight;
    this.pricePerKilo = this.getPricePerKilo();
  }
  private float getPricePerKilo() {
    return this.price / (this.weight / 1000f);
  }
}
