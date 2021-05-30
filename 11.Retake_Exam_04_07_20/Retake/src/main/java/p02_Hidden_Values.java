import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p02_Hidden_Values {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numsArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[numsArr.length];
        int[] prev = new int[numsArr.length];

        dp[0] = numsArr[0];
        for (int i = 1; i < numsArr.length; i++) {
            int currentMaxSum = dp[i - 1];
            int currentNum = numsArr[i];
            if (currentNum >= currentMaxSum + currentNum) {
                dp[i] = currentNum;
                prev[i] = 0;
            } else {
                dp[i] = currentMaxSum + currentNum;
                prev[i] = i - 1;
            }
        }

        int maxArrSum = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > maxArrSum) {
                maxArrSum = dp[i];
            }
        }

        int bestSumIndex = 0;
        int bestSum = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (bestSum < dp[i]) {
                bestSum = dp[i];
                bestSumIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        int prevIndex = -1;
        while (prevIndex != 0) {
            result.add(numsArr[bestSumIndex]);

            prevIndex = prev[bestSumIndex];
            bestSumIndex--;
        }

        Collections.reverse(result);

        System.out.println(maxArrSum);

        for (Integer currentNum : result) {
            System.out.print(currentNum + " ");
        }

        System.out.println();
    }
}
