import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_Variations_without_Repetitions {
    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        elements = reader.readLine().split("\\s+");
        int slotsNum = Integer.parseInt(reader.readLine());
        variations = new String[slotsNum];
        used = new boolean[elements.length];

        variation(0);
    }

    private static void variation(int index) {
        if (index >= variations.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                variations[index] = elements[i];
                used[i] = true;
                variation(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }
}