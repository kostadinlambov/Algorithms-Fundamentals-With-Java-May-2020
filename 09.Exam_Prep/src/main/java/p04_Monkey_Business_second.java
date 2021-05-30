import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p04_Monkey_Business_second {
    public static int[] result;
    public static int[] numbers;
    public static int counter = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        result = new int[n];
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        combinations(0);

        sb.append("Total Solutions: ").append(counter);
        System.out.println(sb.toString());
    }

    private static void combinations(int index) {
        if (index >= result.length) {
            print();
            return;
        }

        result[index] = numbers[index];
        combinations(index + 1);

        result[index] = -numbers[index];
        combinations(index + 1);
    }

    private static void print() {
        int sum = Arrays.stream(result).sum();

        if (sum == 0) {
            counter++;

            for (int currentNum : result) {
                sb.append(currentNum > 0 ? "+" + currentNum : String.valueOf(currentNum)).append(" ");
            }
            sb.append(System.lineSeparator());
        }
    }
}
