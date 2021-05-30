import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p05_Cluster_Border_second {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleShipTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] pairsTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] result = new int[singleShipTimes.length];

        System.out.println();

        for (int i = singleShipTimes.length - 1; i > 1; i--) {
            for (int j = pairsTimes.length - 1; j > 0; j--) {

                int min = Math.min(singleShipTimes[i] + singleShipTimes[i - 1], pairsTimes[j]);
                int min2 = Math.min(singleShipTimes[i-1] + singleShipTimes[i - 2], pairsTimes[j-1]);

//                result[]

                System.out.println(min);


            }
        }

    }
}
