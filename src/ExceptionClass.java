import java.util.Scanner;

public class ExceptionClass {

    // Exception Class example
    public class DivideByZeroException extends Exception {

        // Default constructor - default error message for dividing by zero.
        public DivideByZeroException() {
            super("You cannot divide by zero.");
        }

        // Parameterized constructor - takes in error message to be displayed as String parameter
        public DivideByZeroException(String message) {
            super(message);
        }
    }

    // Demo
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        try {
            if (!keyboard.hasNextDouble()) {
                throw new DivideByZeroException(String.format("%s is not a valid number. The result is still %s",
                        keyboard.next(), "err message"));
            }
        }
        // Catch multiple exceptions in 1 line
        catch (NumberFormatException | DivideByZeroException | UnknownOperatorException e) {
            System.err.println(e.getMessage());
    }
}
