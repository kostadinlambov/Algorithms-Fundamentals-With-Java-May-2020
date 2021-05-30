import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p06_Combinations_with_Repetition {
    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        elements = reader.readLine().split("\\s+");
        int slotsNum = Integer.parseInt(reader.readLine());
        variations = new String[slotsNum];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == variations.length) {
            print();
            return;
        }

        for (int i = start; i < elements.length; i++) {
            variations[index] = elements[i];
            combinations(index + 1, i);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }

}
