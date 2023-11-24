import java.util.Arrays;
import java.util.Random;

class RandomCounter {
  public static Random random = new Random(); 
  public static void main(String[] args) {
    int[] result = new int[10];
    for (int i = 0; i < 1000; i++) {
      final int index = random.nextInt(10);
      result[index]++;
    }
    System.out.println(Arrays.toString(result));
  }
}