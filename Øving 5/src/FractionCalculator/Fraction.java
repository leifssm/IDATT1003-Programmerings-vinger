package FractionCalculator;

class Fraction {
  private int numerator;
  private int denominator;
  public int getNumerator() {
    return numerator;
  }
  public int getDenominator() {
    return denominator;
  }
  Fraction(int numerator) {
    this(numerator, 1);
  }
  Fraction(int numerator, int denominator) {
    if (denominator == 0) throw new IllegalArgumentException("Nevner kan ikke være 0!");
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public void add(Fraction fraction) {
    // if (denominator % fraction.denominator == 0) {
    //   final int difference = denominator / fraction.denominator;
    //   numerator += fraction.numerator * difference;
    // } else if (fraction.denominator % denominator == 0) {
    //   final int difference = fraction.denominator / denominator;
    //   multiply(difference);
    // } else {
    if (denominator == fraction.denominator) {
      numerator += fraction.numerator;
      return;
    }
    final int oldDenomination = denominator;
    multiply(fraction.denominator);
    numerator += fraction.numerator * oldDenomination;
    simplify();
  }
  public void subtract(Fraction fraction) {
    if (denominator == fraction.denominator) {
      numerator -= fraction.numerator;
      return;
    }
    final int oldDenomination = denominator;
    multiply(fraction.denominator);
    numerator -= fraction.numerator * oldDenomination;
    simplify();
  }
  private void multiply(int number) {
    numerator   *= number;
    denominator *= number;
  }
  public void multiply(Fraction fraction) {
    numerator   *= fraction.numerator;
    denominator *= fraction.denominator;
    simplify();
  }
  public void divide(Fraction fraction) {
    numerator   *= fraction.denominator;
    denominator *= fraction.numerator;
    simplify();
  }
  public void simplify() {
    final int gcd = getGreatestCommonDenominator(numerator, denominator);
    numerator   /= gcd;
    denominator /= gcd;
  }
  private int getGreatestCommonDenominator(int a, int b) {
    if (b == 0) return a;
    return getGreatestCommonDenominator(b, a % b);
  }
  public String toString() {
    return numerator + "/" + denominator;
  }
}
