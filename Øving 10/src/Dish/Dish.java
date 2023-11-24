package Dish;

public class Dish {
  private final String name;
  private final String type;
  private final double price;
  private final String recipie;
  public Dish(String name, String type, double price, String recipie) {
    this.name = name;
    this.type = type;
    this.price = price;
    this.recipie = recipie;
  }
  public String getName() {
    return name;
  }
  public String getType() {
    return type;
  }
  public double getPrice() {
    return price;
  }
  public String getRecipie() {
    return recipie;
  }
  public boolean equals(Object o) {
    if (o instanceof Dish) {
      Dish dish = (Dish) o;
      return dish.name.equals(name);
    }
    return false;
  }
  public String toString() {
    return name + " (" + type + "): " + price;
  }
}
