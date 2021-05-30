import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p02_Nuclear_Waste {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] costsArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int flaskToTransport = Integer.parseInt(reader.readLine());

        System.out.println();

        int dp[][] = new int[costsArr.length + 1][costsArr.length + 1];


        for (int currentCountOfFlask = 1; currentCountOfFlask <= costsArr.length ; currentCountOfFlask++) {
            for (int costForAmountOfTasks = 1; costForAmountOfTasks <= costsArr.length; costForAmountOfTasks++) {
                dp[currentCountOfFlask][costForAmountOfTasks] = (flaskToTransport / currentCountOfFlask) * costsArr[costForAmountOfTasks -1];
            }
        }

        System.out.println();

//        for (int i = costsArr.length; i > 0 ; i--) {
//            int k = i;
//            while( k > 0) {
//                dp[k] = (flaskToTransport / k) * costsArr[k - 1];
//
//                k = flaskToTransport % k;
////                k--;
//            }
//        }


    }
}
