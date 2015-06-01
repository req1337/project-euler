import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utils.MathUtils.isPerfectSquare;

/**
 * Problem 3: Largest prime factor
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * <p>
 * Created by thomasalm on 01/04/15.
 */
public class Problem_3 {

    private static final Long TEST_NUMBER = 13195L;
    private static final Long NUMBER = 600_851_475_143L;

    public static void main(String[] args) {
        System.out.println(String.format("The largest prime factor of {%s} is {%s}", TEST_NUMBER, primeFactor(TEST_NUMBER)));
        System.out.println(String.format("The largest prime factor of {%s} is {%s}", NUMBER, primeFactor(NUMBER)));
        fermatFactorization(TEST_NUMBER);
        fermatFactorization(NUMBER);
    }

    /**
     * Brute force
     *
     * @param n
     * @return
     */
    public static Long primeFactor(Long n) {
        List<Long> factors = new ArrayList<>();
        Long d = 2L;
        while (n > 1) {
            while (n % d == 0) {
                factors.add(d);
                n /= d;
            }
            d = d + 1;
        }
        return Collections.max(factors);
    }

    /**
     * http://en.wikipedia.org/wiki/Fermat's_factorization_method
     */
    private static void fermatFactorization(Long n) {
        Long a = (long) Math.ceil(Math.sqrt(n));
        Long b2 = a * a - n;
        while (!isPerfectSquare(b2)) {
            a++;
            b2 = a * a - n;
        }
        Long r1 = a - (long) Math.sqrt(b2);
        Long r2 = n / r1;
        System.out.println(String.format("The roots of {%s} are {%s}, {%s}", n, r1, r2));
    }
}
