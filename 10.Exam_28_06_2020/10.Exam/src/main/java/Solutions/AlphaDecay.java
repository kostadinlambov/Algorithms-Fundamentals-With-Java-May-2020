package Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class AlphaDecay {
    private static int[] atoms;
    private static boolean[] isTaken;
    private static String[] variation;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        atoms = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int slots = Integer.parseInt(scanner.nextLine());

        isTaken = new boolean[atoms.length];
        variation = new String[slots];
        variate(0);
    }

    private static void variate(int n) {
        if (n >= variation.length) {
            printPermutation();
            return;
        }

        for (int i = 0; i < atoms.length; i++) {
            if (!isTaken[i]) {
                isTaken[i] = true;
                variation[n] = String.valueOf(atoms[i]);
                variate(n + 1);
                isTaken[i] = false;
            }
        }
    }

    private static void printPermutation() {
        System.out.println(String.join(" ", variation));
    }
}