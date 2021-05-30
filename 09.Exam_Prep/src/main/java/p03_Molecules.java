import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p03_Molecules {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        int[][] graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            int[] connections = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[connections[0]][connections[1]] = 1;
        }

//        // Print the graph matrix
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length ; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//
//            System.out.println();
//        }

        int start = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);

        boolean[] visited = new boolean[nodes + 1];

        while (!queue.isEmpty()) {

            int node = queue.poll();
            visited[node] = true;

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    queue.offer(i);
                }
            }

        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.print((i) + " ");
            }
        }
    }
}
