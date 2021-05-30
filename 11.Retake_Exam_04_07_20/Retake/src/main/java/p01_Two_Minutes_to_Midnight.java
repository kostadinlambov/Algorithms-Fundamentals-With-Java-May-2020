import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Two_Minutes_to_Midnight {
    private static long[][] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        memory = new long[n + 1][k + 1];

        long binom = calcBinom(n, k);

        System.out.println(binom);
    }

    private static long calcBinom(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        if (memory[n][k] != 0) {
            return memory[n][k];
        }

        return memory[n][k] = calcBinom(n - 1, k) + calcBinom(n - 1, k - 1);
    }
}
