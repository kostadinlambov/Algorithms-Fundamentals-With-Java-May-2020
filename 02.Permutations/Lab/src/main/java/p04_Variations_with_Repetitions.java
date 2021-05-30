import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Variations_with_Repetitions {
    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        elements = reader.readLine().split("\\s+");
        int slotsNum = Integer.parseInt(reader.readLine());
        variations = new String[slotsNum];

        variation(0);
    }

    private static void variation(int index) {
        if (index >= variations.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            variations[index] = elements[i];
            variation(index + 1);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }
}