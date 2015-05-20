/**
 * Problem 6: Sum square difference
 * <p>
 * The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem_6 {

    final static Long MIN = 1L, MAX = 100L;

    public static void main(String[] args) {
        System.out.println(squareOfSum(MIN, MAX) - sumOfSquares(MIN, MAX));
        System.out.println(arithmeticSquareOfSums(MAX) - arithmeticSumOfSquares(MAX));
    }

    private static Long sumOfSquares(Long min, Long max) {
        Long sum = 0L;
        for (Long i = min; i <= max; i++) {
            sum += (long) Math.pow(i, 2);
        }
        return sum;
    }

    private static Long squareOfSum(Long min, Long max) {
        Long sum = 0L;
        for (Long i = min; i <= max; i++) {
            sum += i;
        }
        return (long) Math.pow(sum, 2);
    }

    /**
     * Using basic arithmetic
     */
    private static long arithmeticSquareOfSums(Long N) {
        return (long) Math.pow(N * (N - 1) / 2, 2);
    }

    /**
     * Using basic arithmetic
     */
    private static long arithmeticSumOfSquares(Long N) {
        return (N * (N + 1) * (2 * N + 1)) / 6;
    }

}
