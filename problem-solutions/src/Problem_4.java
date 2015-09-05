/**
 * Problem 4: Largest palindrome number
 * <p>
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * <p>
 * Created by thomasalm on 01/04/15.
 */
public class Problem_4 {

    private final static int MIN = 100, MAX = 999;

    public static void main(String[] args) {
        int m = 0, p;
        for (int i = MIN; i <= MAX; i++) {
            for (int j = i; j <= MAX; j++) {
                p = i * j;
                if (isPalindrome(p)) {
                    m = Math.max(p, m);
                }
            }
        }
        System.out.println("The largest palindrome is: " + m);
    }

    /**
     * Checks if a number is a palindrome
     * http://en.wikipedia.org/wiki/Palindromic_number
     */
    private static boolean isPalindrome(int n) {
        return n == reverseInteger(n);
    }

    /**
     * Reverse an integer
     */
    private static int reverseInteger(int n) {
        int lastDigit, reversedNum = 0;
        while (n != 0) {
            lastDigit = n % 10;
            reversedNum = reversedNum * 10 + lastDigit;
            n = n / 10;
        }
        return reversedNum;
    }

}
