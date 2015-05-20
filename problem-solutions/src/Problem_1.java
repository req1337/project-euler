/**
 * Problem 1: Multiples of 3 and 5
 * <p>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 * <p>
 * Created by thomasalm on 31/03/15.
 */
public class Problem_1 {

    private static final int THREE = 3, FIVE = 5, LIMIT = 1000;

    public static void main(String[] args) {
        System.out.println(String.format("The solution to Problem 1 is: %s", calculateSumUniqueMultiples(THREE, FIVE, LIMIT)));
    }

    /**
     * Calculates the sum of all unique multiples of two numbers.
     * For example: If we list all the natural numbers below 5 that are multiples of 1 or 2,
     * we get 1, 2, 3, 4. The sum of these multiples is 10.
     * Note that we did not count 1, 2, 2, 3, 4, 4 as we only consider the unique multiples.
     *
     * @param a     first multiple
     * @param b     second multiple
     * @param limit highest allowed multiple value
     * @return sum of all multiples of a or b less than limit
     */
    private static int calculateSumUniqueMultiples(final int a, final int b, final int limit) {
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            if (i % a == 0 || i % b == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

}
