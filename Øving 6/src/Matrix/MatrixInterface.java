package Matrix;

public class MatrixInterface {
  public static void main(String[] args) {
    Matrix a = new Matrix(new int[][]{
      {1, 4, 6},
      {6, 2, 1},
    });
    Matrix b = new Matrix(new int[][]{
      {7, 3},
      {1, 6},
      {4, 8},

    });
    // b.add(b).log();
    // b.multiply(a).log();
    a.transpose().log();

  }
}