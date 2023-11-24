package DiceGame;

public class DiceGame {
  public static void main(String[] args) {
    final Player A = new Player("A");
    final Player B = new Player("B");
    Player loser = null;
    Player winner = null;
    do {
      int aDiceRoll = A.rollDice();
      if (aDiceRoll == 1) {
        A.reset();
        System.out.print("A ruller terningen og får 1 og rykker ned til 0.");
      } else {
        A.addScore(aDiceRoll);
        System.out.print("A ruller terningen og får " + aDiceRoll + " til en sum av " + A.getTotal() + "!");
      }
      if (A.isFinished()) {
        winner = A;
        loser = B;
        break;
      }
      int bDiceRoll = B.rollDice();
      if (bDiceRoll == 1) {
        B.reset();
        System.out.println(" B ruller terningen og får 1 og rykker ned til 0.");
      } else {
        B.addScore(bDiceRoll);
        System.out.println(" B ruller terningen og får " + bDiceRoll + " til en sum av " + B.getTotal() + "!");
      }
      if (B.isFinished()) {
        winner = B;
        loser = A;
      }
    } while (winner == null);
    System.out.println(winner.getName() + " vant! Taperen henger etter med en poengsum på " + loser.getTotal());
  }
}
