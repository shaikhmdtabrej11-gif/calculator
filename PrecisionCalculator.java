
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PrecisionCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        BigDecimal a = new BigDecimal(sc.next());

        System.out.print("Enter operator (+,-,*,/): ");
        String operator = sc.next();

        System.out.print("Enter second number: ");
        BigDecimal b = new BigDecimal(sc.next());

        BigDecimal result;

        switch (operator) {

            case "+":
                result = a.add(b);
                break;

            case "-":
                result = a.subtract(b);
                break;

            case "*":
                result = a.multiply(b);
                break;

            case "/":
                if (b.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("Cannot divide by zero");
                    sc.close();
                    return;
                }

                result = a.divide(
                    b, 10, RoundingMode.HALF_UP
                );
                break;

            default:
                System.out.println("Invalid operator");
                sc.close();
                return;
        }

        System.out.println("Precise Result: " + result);

        sc.close();
    }
}
