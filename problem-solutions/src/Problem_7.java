/**
 * Problem 7: 10001st prime
 * <p>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * <p>
 * Created by thomasalm on 16/05/15.
 */
public class Problem_7 {

    private static int TARGET = 10001;

    public static void main(String[] args) {
        System.out.println(String.format("Prime number number {%s} is {%s}", TARGET, generateNthPrimeNumber(TARGET)));
    }

    private static Long generateNthPrimeNumber(int N) {
        int count = 1;
        for (Long i = 3L; i < Long.MAX_VALUE; i+=2L) {
            if(isPrime(i)){
                count++;
                if(count == N){
                    return i;
                }
            }
        }
        return null;
    }

    private static boolean isPrime(long n) {
        for(long i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}


