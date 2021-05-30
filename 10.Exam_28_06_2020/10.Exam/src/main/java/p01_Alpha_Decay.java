import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_Alpha_Decay {
    public static int[] n;
    public static int[] variations;
    public static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int k = Integer.parseInt(reader.readLine());

        variations = new int[k];
        used = new boolean[n.length];

        variation(0);

    }

    private static void variation(int index) {
        if(index >= variations.length){
            print();
            return;
        }

        for (int i = 0; i < n.length; i++) {
            if(!used[i]){
                variations[index] = n[i];
                used[i] = true;
                variation(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {

        for (int variation : variations) {
            System.out.print(variation + " ");
        }

        System.out.println();
    }
}
