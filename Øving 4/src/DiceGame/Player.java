package DiceGame;

import java.util.Random;

public class Player {
  private String name;
  private int total = 0;
  private Random dice = new Random();
  Player(String nameString) {
    name = nameString;
  }
  public String getName() {
    return name;
  }
  public int rollDice() {
    return dice.nextInt(6) + 1;
  }
  public void reset() {
    total = 0;
  }
  public void addScore(int score) {
    total += score;
  }
  public int getTotal() {
    return total;
  }
  public boolean isFinished() {
    return total >= 100;
  }
}
