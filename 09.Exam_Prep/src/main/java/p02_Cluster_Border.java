import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p02_Cluster_Border {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleShipTime = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] pairsTime = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        int[] dp = new int[singleShipTime.length + 1];

        dp[1] = singleShipTime[0];

        for (int i = 2; i <= singleShipTime.length; i++) {
            dp[i] = Math.min(dp[i - 1] + singleShipTime[i - 1], dp[i - 2] + pairsTime[i - 2]);
        }

        System.out.println("Optimal Time: " + dp[singleShipTime.length]);

        Deque<String> result = new ArrayDeque<>();

        for (int i = dp.length - 1; i > 0 ; i--) {
            int timeDiffForLatestTwo = dp[i] - dp[i-1];

            if(timeDiffForLatestTwo == singleShipTime[i - 1]){
                result.addFirst("Single " + i);
            } else {
                result.addFirst("Pair of " + (i - 1) + " and " + i);
                i--;
            }
        }

        for (String value : result) {
            System.out.println(value);
        }
    }
}
