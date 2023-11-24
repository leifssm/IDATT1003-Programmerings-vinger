package Restaurant;

import java.util.ArrayList;

import Dish.Dish;
import Menu.Menu;

public class MenuRegister {
  private ArrayList<Menu> menus = new ArrayList<Menu>();
  private ArrayList<Dish> dishes = new ArrayList<Dish>();

  public ArrayList<Menu> getMenus() {
    return menus;
  }
  public ArrayList<Dish> getDishes() {
    return dishes;
  }

  MenuRegister() {}

  public void addMenu(String ...strings) {
    Menu menu = new Menu();
    for (String string : strings) {
      Dish dish = getDish(string);
      if (dish != null) menu.addDish(dish);
    }
    menus.add(menu);
  }
  public void addDish(Dish dish) {
    if (dishes.contains(dish)) throw new IllegalArgumentException("Menu already exists");
    dishes.add(dish);
  } 
  public Dish getDish(String name) {
    for (Dish dish : dishes) {
      if (dish.getName().equals(name)) {
        return dish;
      }
    }
    return null;
  }
  public ArrayList<Dish> getDishesFromType(String type) {
    ArrayList<Dish> result = new ArrayList<Dish>();
    for (Dish dish : dishes) {
      if (dish.getType().equals(type)) {
        result.add(dish);
      }
    }
    return result;
  }
  public ArrayList<Menu> getMenusWithTotalPriceBetween(double min, double max) {
    ArrayList<Menu> result = new ArrayList<Menu>();
    for (Menu menu : menus) {
      final double totalPrice = menu.getTotalPrice();
      if (min <= totalPrice && totalPrice <= max) result.add(menu);
    }
    return result;
  }
  public String toString() {
    String result = "----- Menu Register -----\n";
    for (Menu menu : menus) {
      result += menu + "\n";
    }
    return result;
  }
}