package Menu;

import java.util.ArrayList;

import Dish.Dish;


public class Menu {
  private final ArrayList<Dish> dishes;
  public Menu() {
    this(new ArrayList<Dish>());
  }
  public Menu(Dish ...dishes) {
    this(new ArrayList<Dish>());
    for (Dish dish : dishes) {
      this.dishes.add(dish);
    }
  }
  public Menu(ArrayList<Dish> dishes) {
    this.dishes = dishes;
  }
  public void addDish(Dish dish) {
    if (dishes.contains(dish)) {
      throw new IllegalArgumentException("Dish already exists");
    }
    dishes.add(dish);
  }
  public double getTotalPrice() {
    double result = 0;
    for (Dish dish : dishes) {
      result += dish.getPrice();
    }
    return result;
  }
  public String toString() {
    String result = "----- Menu -----\n";
    for (Dish dish : dishes) {
      result += dish + "\n";
    }
    result += "--- Total: " + getTotalPrice() + "kr ---\n";
    return result;
  }
  
}
