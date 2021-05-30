package exercise;

/**
 * Question: You are given coins of different denominations and
 * a total amount of money. Write a function to compute the number
 * of combinations that make up that amount. You may assume that you
 * have an infinite number of each kind of coin.
 */
public class p02_Unique_Ways_To_Make_Change {
    public static void main(String[] args) {

        // Input
//        int[] coins = {1, 2, 5};
//        int amount = 5;

//        int[] coins = {1, 2, 5, 10};
//        int amount = 13;

        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        int amount = 100;

        int[][] dp = new int[coins.length + 1][amount + 1];

        // Fill the first row
        for (int col = 0; col <= amount; col++) {
            dp[0][col] = 0;
        }

        // Fill the first col
        for (int row = 0; row <= coins.length; row++) {
            dp[row][0] = 1;
        }

        for (int row = 1; row <= coins.length; row++) {
            for (int col = 1; col <= amount; col++) {
                int notUseTheCoinCount = col - coins[row - 1] >= 0 ? dp[row][col - coins[row - 1]] : 0;
                int useTheCoinCount = dp[row - 1][col];
                dp[row][col] = useTheCoinCount + notUseTheCoinCount;
            }
        }

        System.out.printf("They are %d combinations", dp[coins.length][amount]);

    }
}
