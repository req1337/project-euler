import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Problem 8: Largest product in a series
 * <p>
 * The four adjacent digits in the 1000-digit number (numbers.txt)
 * that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * Find the thirteen adjacent digits in the 1000-digit number
 * that have the greatest product. What is the value of this product?
 * <p>
 * Created by thomasalm on 17/05/15.
 */
public class Problem_8 {

    private final static int ADJACENT_DIGITS = 13;

    public static void main(String[] args) throws IOException {
        //TODO: Fix project run config - should be Resources/numbers.txt
        String d = new String(Files.readAllBytes(Paths.get("../project-euler/problem-solutions/src/Resources/numbers.txt")));
        int[] intArray = stringToIntArray(d);
        System.out.println("Result:" + adjacentDigitProduct(intArray, ADJACENT_DIGITS));
    }

    private static int[] stringToIntArray(String d){
        int[] intArray = new int[d.length()];
        for (int i = 0; i < d.length(); i++) {
            intArray[i] = Character.digit(d.charAt(i), 10);
        }
        return intArray;
    }

    private static long adjacentDigitProduct(int[] d, int N){
        long largest = 0, product;
        for(int i = 0; i < d.length-N; i++){
            product = 1;
            for(int j = i; j < i + N; j++){
                product *= d[j];
            }
            if(product > largest){
                largest = product;
            }
        }
        return largest;
    }
}
