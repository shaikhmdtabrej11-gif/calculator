
import java.util.HashMap;
import java.util.Map;

interface Strategy {
    double execute(double a, double b);
}

class Add implements Strategy {
    public double execute(double a, double b) {
        return a + b;
    }
}

class Subtract implements Strategy {
    public double execute(double a, double b) {
        return a - b;
    }
}

class Multiply implements Strategy {
    public double execute(double a, double b) {
        return a * b;
    }
}

class Divide implements Strategy {
    public double execute(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Division by zero");

        return a / b;
    }
}

public class StrategyCalculator {

    public static void main(String[] args) {

        Map<String, Strategy> strategies = new HashMap<>();

        strategies.put("+", new Add());
        strategies.put("-", new Subtract());
        strategies.put("*", new Multiply());
        strategies.put("/", new Divide());

        String operator = "*";

        double a = 25;
        double b = 4;

        Strategy strategy = strategies.get(operator);

        if (strategy != null) {
            System.out.println(
                "Result: " + strategy.execute(a, b)
            );
        } else {
            System.out.println("Invalid operator");
        }
    }
}
