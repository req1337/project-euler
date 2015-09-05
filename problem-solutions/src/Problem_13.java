import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thomasalm on 04/06/15.
 */
public class Problem_13 {

    public static void main(String[] args) throws IOException {

        String numbers = new String(Files.readAllBytes(Paths.get("../project-euler/problem-solutions/src/Resources/problem13.txt")));

        String[] num = numbers.split("\\r?\\n");

        List<BigInteger> list = new ArrayList<BigInteger>();

        for(String n : num){
            list.add(new BigInteger(n));
        }

        BigInteger sum = new BigInteger("0");

        for(int i = 0; i < list.size(); i++){
            sum.add(list.get(i));
        }





    }

}