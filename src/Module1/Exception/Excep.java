package Module1.Exception;

public class Excep {

        public static int divideNumbers(int a, int b) throws ArithmeticException {
            if (b == 0) {
                throw new ArithmeticException("You cannot divide a number by zero!");
            }
            return a / b;
        }

        public static void main(String[] args) {
            try {
                int result = divideNumbers(10, 0);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Caught Error: " + e.getMessage());
            } finally {
                System.out.println("Finally block: Cleaning up resources.");
            }
        }
    }

