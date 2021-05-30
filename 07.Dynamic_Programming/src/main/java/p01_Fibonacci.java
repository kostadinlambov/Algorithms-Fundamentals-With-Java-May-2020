import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Fibonacci {
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        memo = new int[num +1];

        int fibonacci = fibonacci(num);

        System.out.println(fibonacci);
    }

    private static int fibonacci(int num) {
        if (num <= 2) {
            return 1;
        }

        if(memo[num] != 0){
            return memo[num];
        }

        return  memo[num] = fibonacci(num - 1) + fibonacci(num - 2);
    }
}
