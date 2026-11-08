
import java.util.*;

public class ScientificCalculator {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> history = new ArrayList<>();

    static double calculate(int choice, double a, double b) {

        switch (choice) {

            case 1: return a + b;
            case 2: return a - b;
            case 3: return a * b;

            case 4:
                if (b == 0)
                    throw new ArithmeticException("Division by zero!");
                return a / b;

            case 5: return Math.pow(a, b);
            case 6: return Math.sqrt(a);
            case 7: return a % b;
            case 8: return Math.sin(Math.toRadians(a));
            case 9: return Math.cos(Math.toRadians(a));
            case 10: return Math.tan(Math.toRadians(a));
            case 11: return a * b / 100;

            default:
                throw new IllegalArgumentException("Invalid choice!");
        }
    }

    static long factorial(int n) {

        if (n < 0 || n > 20)
            throw new IllegalArgumentException(
                "Enter factorial between 0 and 20");

        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    static void showHistory() {
        System.out.println("\n--- Calculation History ---");

        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            history.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SCIENTIFIC CALCULATOR =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Modulus");
            System.out.println("8. Sin");
            System.out.println("9. Cos");
            System.out.println("10. Tan");
            System.out.println("11. Percentage");
            System.out.println("12. Factorial");
            System.out.println("13. History");
            System.out.println("14. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 14) {
                System.out.println("Calculator Closed!");
                break;
            }

            if (choice == 13) {
                showHistory();
                continue;
            }

            try {

                double a, b = 0, result;

                if (choice == 12) {

                    System.out.print("Enter number: ");
                    int n = sc.nextInt();

                    result = factorial(n);

                } else {

                    if (choice < 1 || choice > 11) {
                        throw new IllegalArgumentException(
                            "Invalid choice!");
                    }

                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();

                    if (choice == 6 || (choice >= 8 && choice <= 10)) {
                        result = calculate(choice, a, 0);
                    } else {
                        System.out.print("Enter second number: ");
                        b = sc.nextDouble();

                        result = calculate(choice, a, b);
                    }
                }

                System.out.println("Result = " + result);
                history.add("Operation " + choice + " = " + result);

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid numbers.");
                sc.nextLine();

            } catch (ArithmeticException |
                     IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
