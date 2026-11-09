
import java.util.Scanner;

class BasicCalculator {

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BasicCalculator calc = new BasicCalculator();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter operator (+,-,*,/): ");
        char op = sc.next().charAt(0);

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        double result = 0;

        switch (op) {
            case '+': result = calc.add(a, b); break;
            case '-': result = calc.subtract(a, b); break;
            case '*': result = calc.multiply(a, b); break;
            case '/': result = calc.divide(a, b); break;
            default:
                System.out.println("Invalid operator");
                sc.close();
                return;
        }

        System.out.println("Result = " + result);
        sc.close();
    }
}
