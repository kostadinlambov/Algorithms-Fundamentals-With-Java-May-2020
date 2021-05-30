package exercise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Question: Given an integer array, find the contiguous subarray (containing at least one
 * number) which has the largest sum and return its sum.
 */

public class p04_Max_Contiguous_Subarray_Sum {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int[] numsArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] numsArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        int[] dp = new int[numsArr.length];

        dp[0] = numsArr[0];
        for (int i = 1; i < numsArr.length; i++) {
            int currentMaxSum = dp[i - 1];
            int currentNum = numsArr[i];
            if (currentNum >= currentMaxSum + currentNum) {
                dp[i] = currentNum;
            } else {
                dp[i] = currentMaxSum + currentNum;
            }
        }

        int maxArrSum = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > maxArrSum) {
                maxArrSum = dp[i];
            }
        }

        System.out.println("The largest sum in a contiguous subarray is: " + maxArrSum);
    }
}
