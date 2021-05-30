package p04_SumOfCoins;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Arrays.sort(coins);

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoin = coins[i];
            int currentNumOfCoins = targetSum / currentCoin;
            if (currentNumOfCoins > 0) {
                usedCoins.put(currentCoin, currentNumOfCoins);
                targetSum -= currentNumOfCoins * currentCoin;

                if (targetSum == 0) {
                    return usedCoins;
                }
            }
        }

        if (targetSum > 0) {
            throw new IllegalArgumentException();
        }

        return usedCoins;
    }
}