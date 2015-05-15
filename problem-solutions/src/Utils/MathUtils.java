package Utils;

/**
 * Created by thomasalm on 10/05/15.
 */
public class MathUtils {

    /** function to check if N is a perfect square or not **/
    public static boolean isPerfectSquare(long N)
    {
        long sqr = (long) Math.sqrt(N);
        if (sqr * sqr == N || (sqr + 1) * (sqr + 1) == N)
            return true;
        return false;
    }
}
