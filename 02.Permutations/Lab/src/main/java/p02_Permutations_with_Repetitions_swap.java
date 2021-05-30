import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p02_Permutations_with_Repetitions_swap {
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
        Set<String> swapped = new HashSet<>();
        swapped.add(elements[index]);

        for (int i = index + 1; i < elements.length; i++) {
            if(!swapped.contains(elements[i])){
                swap(index, i);
                permute(index + 1);
                swap(index, i);
                swapped.add(elements[i]);
            }

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
