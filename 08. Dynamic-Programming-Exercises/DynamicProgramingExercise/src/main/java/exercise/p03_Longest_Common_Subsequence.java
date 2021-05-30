package exercise;

/**
 * Question: You are given 2 strings. Return the length of the longest
 * subsequence that the 2 strings share.
 */

public class p03_Longest_Common_Subsequence {
    public static void main(String[] args) {
        // Input
        String firstStr = "AGGTAB";
        String secondStr = "GXTXAYB";

        int[][] dp = new int[firstStr.length() + 1][secondStr.length() + 1];

        for (int i = 1; i <= firstStr.length(); i++) {
            for (int j = 1; j <= secondStr.length(); j++) {
                if(firstStr.charAt(i - 1) == secondStr.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println("The length of the Longest Common Subsequence is: " + dp[firstStr.length()][secondStr.length()]);
    }
}
