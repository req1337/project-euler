/**
 * Problem 5: Smallest multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Created by thomasalm on 01/04/15.
 */
public class Problem_5 {

    private static Long MIN = 1L, MAX = 20L, LIMIT = Long.MAX_VALUE, INCREMENT = 20L;

    public static void main(String[] args) {
        for (Long i = MAX; i < LIMIT; i += INCREMENT) {
            if(isEvenlyDivisible(i)){
                System.out.println("Result: " + i);
                break;
            }
        }
    }

    public static boolean isEvenlyDivisible(Long n){
        for (Long j = MIN; j <= MAX; j++) {
            if (n % j != 0) {
                return false;
            }
        }
        return true;
    }
}
