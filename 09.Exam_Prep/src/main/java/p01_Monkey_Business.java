import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_Monkey_Business {
    public static int n;
    public static int solutions = 0;
    public static int[] expression;
    public static StringBuilder result = new StringBuilder();
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        expression = new int[n];
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

//        combinationsWithoutRep(0, 1);
        combinationsWithoutRep(0);

        result.append("Total Solutions: ").append(solutions);

        System.out.println(result.toString());
    }

    private static void combinationsWithoutRep(int index) {
        if (index >= n) {
            printSolution();
        } else {
            expression[index] = numbers[index];
            combinationsWithoutRep(index + 1);
            expression[index] = -numbers[index];
            combinationsWithoutRep(index + 1);
        }
    }

//    private static void combinationsWithoutRep(int index, int start) {
//        if (index >= n) {
//            printSolution();
//        } else {
//            for (int i = start; i <= n; i++) {
//                expression[index] = i;
//                combinationsWithoutRep(index + 1, i + 1);
//                expression[index] = -i;
//                combinationsWithoutRep(index + 1, i + 1);
//            }
//        }
//    }

    private static void printSolution() {
        int sum = Arrays.stream(expression).sum();
        if (sum == 0) {
            solutions++;
            for (int value : expression) {
                String numberStr = value > 0 ? "+" + value : String.valueOf(value);

                result.append(numberStr).append(" ");
            }

            result.append(System.lineSeparator());
        }
    }
}
