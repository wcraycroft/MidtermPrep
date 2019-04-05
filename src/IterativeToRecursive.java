
// Iterative <---> Recursive
// Decimal > Binary
// GCD
// Palindrome

public class IterativeToRecursive {


    public static String recursiveToBinary(int decimal, String binary) {

        // Base case, if decimal number / 2 = 0
        if (decimal / 2 == 0) {
            return binary + (decimal % 2);
        }
        // Add remainder of decimal / 2 to end of recursive String
        return recursiveToBinary(decimal / 2, binary) + (decimal % 2);

    }

    public static String iterativeToBinary(int decimal) {

        String binary = "";

        while (decimal / 2 != 0) {
            // Add remainder of decimal / 2 to start of binary String
            binary = (decimal % 2) + binary;
            // Divide decimal nby 2
            decimal /= 2;
        }
        // Add final remainder to start of String and return it
        return (decimal % 2) + binary;
    }





    // Calculates the GCD of two passed integers using recursive method
    public static int recursivelyCalculateGCD(int numberA, int numberB) {
        // Base case, b = 0, a is the GCD
        if (numberB == 0)
            return numberA;

        // Otherwise return the GCD of b and a % b
        return recursivelyCalculateGCD(numberB, numberA % numberB);
    }
    // Calculates the GCD of two passed integers using iterative method
    public static int iterativelyCalculateGCD(int numberA, int numberB) {
        int temp;
        // Calculate and replace first number with remainder of a % b, until b is equal to 0
        while (numberB != 0) {
            temp = numberB;
            numberB = numberA % numberB;
            numberA = temp;
        }
        // When b = 0, return A as GCD
        return numberA;
    }



    // This recursive method returns True if the input String is a Palindrome (reads forwards and backwards)
    public static boolean recursiveTestPalindrome(String text) {
        // Base condition: if string length is <2 return true
        if (text.length() < 2)
            return true;

        // Test if first and last character match
        if (text.substring(0,1).equals(text.substring(text.length() - 1))) {
            // call recursively for remaining chars
            return recursiveTestPalindrome(text.substring(1, text.length() - 1));
        }
        // Else, it is not a palindrome
        return false;
    }

    // This iterative method returns True if the input String is a Palindrome (reads forwards and backwards)
    public static boolean iterativeTestPalindrome(String text) {
        // Loop through first half of string
        for (int i = 0; i < text.length() / 2; i++) {
            // Test if char at index i is equals to it counterpart at last char - i
            if (!text.substring(i, i + 1).equals(
                    text.substring(text.length() - (i + 1), text.length() - i)))
                // If not equal, return false
                return false;
        }
        // All characters match, return true
        return true;
    }
}
