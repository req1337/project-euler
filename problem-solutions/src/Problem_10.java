/**
 * Problem 10: Summation of primes
 * <p>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 * <p>
 * Created by thomasalm on 21/05/15.
 */
public class Problem_10 {

    final static int LIMIT = 2_000_000;

    /**
     * Reused the code from Problem 7
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findSumOfAllPrimes(LIMIT));
    }

    private static long findSumOfAllPrimes(int N) {
        long sum = 2L;
        for (Long i = 3L; i < N; i += 2L) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isPrime(long n) {
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
