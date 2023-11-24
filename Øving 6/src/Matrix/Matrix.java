package Matrix;

import java.util.Arrays;

public class Matrix {
  private int[][] matrix;
  private int height;
  private int width;
  public int getHeight() {
    return height;
  }
  public int getWidth() {
    return width;
  }
  Matrix(int[][] matrix) {
    this.matrix = matrix;
    this.height = matrix.length;
    this.width = matrix[0].length;
  }
  public int get(int x, int y) {
    return this.matrix[y][x];
  }
  public Matrix add(Matrix matrix) {
    if (height != matrix.height || width != matrix.width) throw new IllegalArgumentException();
    Matrix newMatrix = copy();
    for (int y = 0; y < this.matrix.length; y++) {
      for (int x = 0; x < this.matrix[y].length; x++) {
        newMatrix.matrix[y][x] += matrix.get(x, y);
      }
    }
    return newMatrix;
  }
  public Matrix multiply(Matrix matrix) {
    if (this.height != matrix.width) throw new IllegalArgumentException();
    int[][] newMatrix = new int[this.height][matrix.width];
    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < matrix.width; x++) {
        int total = 0;
        
        for (int n = 0; n < this.width; n++) {
          
          System.out.println("x:" + x + " y:" + y + " n:" + n);
          int v = get(n, y);
          int w = matrix.get(x, n);
          System.out.println(v + " " + w);
          total += v * w;
        }

        newMatrix[y][x] = total;
      }
    }
    return new Matrix(newMatrix);
  }
  public Matrix transpose() {
    int[][] newMatrix = new int[width][height];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        newMatrix[x][y] = get(x, y);
      }
    }
    return new Matrix(newMatrix);
  }
  private Matrix copy() {
    int[][] matrix = new int[this.matrix.length][this.matrix[0].length];
    for (int y = 0; y < this.matrix.length; y++) {
      for (int x = 0; x < this.matrix[y].length; x++) {
        matrix[y][x] = this.matrix[y][x];
      }
    }
    return new Matrix(matrix);
  }
  public void log() {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }
}
