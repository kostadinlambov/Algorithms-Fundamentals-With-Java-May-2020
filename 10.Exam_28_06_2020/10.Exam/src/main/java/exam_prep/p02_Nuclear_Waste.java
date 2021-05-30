package exam_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p02_Nuclear_Waste {
    public static int[] costsArr;
    public static int[] minPrises;
    public static int[] prevIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        costsArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int flaskToTransport = Integer.parseInt(reader.readLine());

        minPrises = new int[flaskToTransport + 1];
        prevIndex = new int[flaskToTransport + 1];

        int[] dp = new int[flaskToTransport + 1];

        Arrays.fill(minPrises, Integer.MAX_VALUE);








    }
}
