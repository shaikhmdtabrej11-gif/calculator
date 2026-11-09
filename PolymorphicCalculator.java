
import java.util.Scanner;

abstract class CalculatorOperation {

    abstract double calculate(double a, double b);

    abstract String getOperationName();
}

class Addition extends CalculatorOperation {
    double calculate(double a, double b) {
        return a + b;
    }

    String getOperationName() {
        return "Addition";
    }
}

class Subtraction extends CalculatorOperation {
    double calculate(double a, double b) {
        return a - b;
    }

    String getOperationName() {
        return "Subtraction";
    }
}

class Multiplication extends CalculatorOperation {
    double calculate(double a, double b) {
        return a * b;
    }

    String getOperationName() {
        return "Multiplication";
    }
}

class Division extends CalculatorOperation {
    double calculate(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Division by zero");

        return a / b;
    }

    String getOperationName() {
        return "Division";
    }
}

public class PolymorphicCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CalculatorOperation[] operations = {
            new Addition(),
            new Subtraction(),
            new Multiplication(),
            new Division()
        };

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        for (CalculatorOperation op : operations) {
            try {
                System.out.println(
                    op.getOperationName() + ": " +
                    op.calculate(a, b)
                );
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
