
import java.util.Scanner;

@FunctionalInterface
interface Operation {
    double calculate(double a, double b);
}

public class LambdaCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Operation addition = (a, b) -> a + b;
        Operation subtraction = (a, b) -> a - b;
        Operation multiplication = (a, b) -> a * b;
        Operation division = (a, b) ->
            b != 0 ? a / b :
            Double.NaN;

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Addition: " +
            addition.calculate(a, b));

        System.out.println("Subtraction: " +
            subtraction.calculate(a, b));

        System.out.println("Multiplication: " +
            multiplication.calculate(a, b));

        System.out.println("Division: " +
            division.calculate(a, b));

        sc.close();
    }
}
