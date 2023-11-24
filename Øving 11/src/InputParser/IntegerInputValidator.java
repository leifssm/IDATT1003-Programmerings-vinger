package InputParser;

@FunctionalInterface
public interface IntegerInputValidator {
  boolean test(int input);
}