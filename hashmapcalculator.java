
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class HashMapCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, DoubleBinaryOperator> operations =
            new HashMap<>();

        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException(
                    "Division by zero");
            }
            return a / b;
        });
        operations.put("%", (a, b) -> a % b);
        operations.put("^", Math::pow);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter operator (+,-,*,/,%,^): ");
        String operator = sc.next();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        try {
            DoubleBinaryOperator operation =
                operations.get(operator);

            if (operation == null) {
                throw new IllegalArgumentException(
                    "Invalid operator");
            }

            System.out.println("Result: " +
                operation.applyAsDouble(a, b));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
