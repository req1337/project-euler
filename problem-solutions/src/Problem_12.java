/**
 * Problem 12: Highly divisible triangular number
 * <p>
 * Created by thomasalm on 01/06/15.
 */
public class Problem_12 {

    private static final int DIVISORS = 500;

    public static void main(String[] args) {

        int n = 0, i = 1;

        while (divisors(n) < DIVISORS) {
            n += i;
            i++;
        }

        System.out.println("Result: " + n);
    }

    private static int divisors(int number) {

        int d = 0, sqrt = (int) Math.sqrt(number);

        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                d += 2;
            }
        }
        //Subtract one if the number is a perfect square
        return (Math.pow(sqrt, 2) == number) ? --d : d;

    }

}
