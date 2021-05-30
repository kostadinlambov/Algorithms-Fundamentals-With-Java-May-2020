import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_2_Permutations_without_Repetitions {
    public static String[] elements;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        elements = reader.readLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(index, i);
            permute(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }


    private static void print(String[] permutes) {
        System.out.println(String.join(" ", permutes));
    }
}
