package exercise;

import java.util.Arrays;

/**
 * Question: You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1
 */
public class p01_Change_making_problem_Fewest_coins_to_make_change {
    public static void main(String[] args) {

        // Input
        int[] coins = {1, 2, 5};
        int amount = 12;


        // Memoization
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(j - coins[i] >= 0){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1 );
                }
            }
        }
        System.out.printf("The fewest number of coins is to make up %d is %d", amount, dp[amount]);
    }
}
