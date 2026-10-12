package Module1.Lamda;

public class Functional {

    @FunctionalInterface
    interface Calculator {
        double calculate(double a, double b);
    }

    public static void main(String[] args) {
            Calculator addition = (a, b) -> a + b;
            Calculator subtraction = (a, b) -> a - b;
            Calculator multiplication = (a, b) -> a * b;
            Calculator division = (a, b) -> {
                if (b == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    return 0;
                }
                return a / b;
            };
            Calculator modulus = (a, b) -> a % b;

            double num1 = 20.0;
            double num2 = 6.0;

            System.out.println(addition.calculate(num1, num2));
            System.out.println(subtraction.calculate(num1, num2));
            System.out.println(multiplication.calculate(num1, num2));
            System.out.println(division.calculate(num1, num2));
            System.out.println(modulus.calculate(num1, num2));
        }
    }
