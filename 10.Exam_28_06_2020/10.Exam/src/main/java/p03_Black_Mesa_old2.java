import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p03_Black_Mesa_old2 {
    public static boolean[] visited;
    public static int[] prevNodes;

    public static Map<Integer, Integer> mapIndexes = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfVersions = Integer.parseInt(reader.readLine());

        int connections = Integer.parseInt(reader.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numberOfVersions + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connections; i++) {
            int[] paths = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            mapIndexes.put(paths[0], i);

            graph.get(paths[0]).add(paths[1]);
        }


//        int[][] graph = new int[numberOfVersions + 1][numberOfVersions + 1];

//        for (int i = 0; i < connections; i++) {
//            int[] pairVersion = Arrays.stream(reader.readLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//
//            graph[pairVersion[0]][pairVersion[1]] = 1;
//        }

        int source = Integer.parseInt(reader.readLine());
        int destination = Integer.parseInt(reader.readLine());

        visited = new boolean[numberOfVersions + 1];
        prevNodes = new int[numberOfVersions + 1];

        Arrays.fill(prevNodes, -1);

        bfs(graph, source ,destination);

        List<Integer> path = new ArrayList<>();

        path.add(destination);

        int prevNode = prevNodes[destination];

        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        for (int i = path.size()-1; i >= 0 ; i--) {
//            if(i <= Math.max(source, destination)){
                System.out.print(path.get(i) + " ");
//            }
        }

        System.out.println();

        int counter = 0;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                counter++;
                System.out.print((i) + " ");
            }
        }

        if(counter == 0){
            System.out.println();
        }
    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == destination) {
                return;
            }

            for (int child : graph.get(node)) {
//                child = mapIndexes.get(child);
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }
    }


}
