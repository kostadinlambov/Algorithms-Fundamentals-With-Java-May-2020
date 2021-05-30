import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p07_N_Choose_K_Count {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        int binomKoef = binom(n, k);
        System.out.println(binomKoef);
    }

    private static int binom(int n, int k) {
        if (k > n) {
            return 0;
        }

        if (k == 0 || k == n) {
            return 1;
        }

        return binom(n - 1, k - 1) + binom(n - 1, k );
    }
}
