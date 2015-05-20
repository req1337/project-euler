/**
 * Problem 5: Smallest multiple
 * <p>
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * <p>
 * Created by thomasalm on 01/04/15.
 */
public class Problem_5 {

    private static Long INCREMENT = 20L;

    public static void main(String[] args) {
        for (Long i = INCREMENT; i < Long.MAX_VALUE; i += INCREMENT) {
            if (isEvenlyDivisible(i)) {
                System.out.println("Result: " + i);
                break;
            }
        }
    }

    /**
     * Checks if a number is evenly divisible with every number between MAX and MIN
     * <p>
     * Every number is evenly dividable with 1, MIN = 2
     * Every number generated in the main loop is divisible by 20, MIN = 19
     * Starting with MAX speeds up the elimination process
     */
    public static boolean isEvenlyDivisible(Long n) {
        for (Long j = INCREMENT - 1; j >= 2L; j--) {
            if (n % j != 0) {
                return false;
            }
        }
        return true;
    }
}
