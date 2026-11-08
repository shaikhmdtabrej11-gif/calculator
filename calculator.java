
import java.util.Scanner;

public class AdvancedCalculator {

    public static double calculate(double a, double b, int choice) {

        switch (choice) {

            case 1:
                return a + b;

            case 2:
                return a - b;

            case 3:
                return a * b;

            case 4:
                if (b == 0) {
                    throw new ArithmeticException(
                        "Cannot divide by zero!");
                }
                return a / b;

            case 5:
                if (b == 0) {
                    throw new ArithmeticException(
                        "Cannot modulus by zero!");
                }
                return a % b;

            case 6:
                return Math.pow(a, b);

            default:
                throw new IllegalArgumentException(
                    "Invalid choice!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ADVANCED CALCULATOR =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Power");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 7) {
                System.out.println("Calculator Closed!");
                break;
            }

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            try {
                double result = calculate(a, b, choice);
                System.out.println("Result = " + result);
            }
            catch (ArithmeticException |
                   IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
