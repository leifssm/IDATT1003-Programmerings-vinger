package Restaurant;

import Dish.Dish;
import Menu.Menu;

public class RestaurantTester {
  public static void main(String[] args) {
    MenuRegister register = new MenuRegister();
    register.addDish(new Dish("Pasta", "Main", 10, "Boil pasta"));
    register.addDish(new Dish("Pizza", "Main", 15, "Bake pizza"));
    register.addDish(new Dish("Salad", "Main", 5, "Mix salad"));
    register.addDish(new Dish("Ice Cream", "Dessert", 5, "Freeze ice cream"));
    register.addDish(new Dish("Cake", "Dessert", 10, "Bake cake"));
    register.addDish(new Dish("Fruit", "Dessert", 5, "Cut fruit"));
    register.addDish(new Dish("Water", "Drink", 1, "Pour water"));
    register.addDish(new Dish("Soda", "Drink", 2, "Pour soda"));
    register.addDish(new Dish("Juice", "Drink", 3, "Pour juice"));
    register.addMenu("Pasta", "Pizza", "Salad", "Water");
    
    System.out.println("Cake dish: " + register.getDish("Cake"));
    System.out.println();
    System.out.println("All dishes:");
    for (Dish dish : register.getDishes()) {
      System.out.println(dish);
    }
    System.out.println();
    System.out.println("Cake from menu: " + register.getDish("Cake"));
    System.out.println("Main dishes:");
    for (Dish dish : register.getDishesFromType("Main")) {
      System.out.println(dish.getName());
    }
    System.out.println();
    System.out.println("Desserts:");
    for (Dish dish : register.getDishesFromType("Dessert")) {
      System.out.println(dish.getName());
    }
    System.out.println();
    System.out.println("Drinks:");
    for (Dish dish : register.getDishesFromType("Drink")) {
      System.out.println(dish.getName());
    }
    System.out.println();
    System.out.println("Menus with total price less than 40:");
    for (Menu m : register.getMenusWithTotalPriceBetween(0, 40)) {
      System.out.println(m);
    }
  }
}
