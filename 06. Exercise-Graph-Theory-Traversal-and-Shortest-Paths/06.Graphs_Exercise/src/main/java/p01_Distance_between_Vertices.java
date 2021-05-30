import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p01_Distance_between_Vertices {
    public static boolean[] visited;
    public static Map<Integer, Integer> mapIndexes = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int verticesNumber = Integer.parseInt(reader.readLine());
        int pairsForDistanceToFindCount = Integer.parseInt(reader.readLine());

        visited = new boolean[verticesNumber + 1];

        List<List<Integer>> pairList = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());


        // Fill the graph
        for (int i = 1; i <= verticesNumber; i++) {
            String[] inputArr = reader.readLine().split(":");

            graph.add(new ArrayList<>());

            mapIndexes.put(Integer.parseInt(inputArr[0]), i);

            if (inputArr.length > 1) {
                List<Integer> edges = Arrays.stream(inputArr[1].split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                graph.get(i).addAll(edges);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Iterate over all Pairs and calculate the current path between two nodes
        for (int i = 0; i < pairsForDistanceToFindCount; i++) {
            List<Integer> currentPair = Arrays.stream(reader.readLine().split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Integer source = currentPair.get(0);
            Integer destination = currentPair.get(1);

            pairList.add(currentPair);

            int[] prevNodes = new int[verticesNumber + 1];
            Arrays.fill(prevNodes, -1);

            topSort(graph, result, mapIndexes.get(source), mapIndexes.get(destination), prevNodes);

            List<Integer> path = new ArrayList<>();

            int parent = prevNodes[mapIndexes.get(destination)];

            // Recover the shortest path
            while (parent != -1) {
                path.add(parent);
                parent = prevNodes[parent];
            }

            int distance = path.isEmpty() ? -1 : path.size();

            // print result
            System.out.printf("{%d, %d} -> %d\n", source, destination, distance);

            result.clear();
        }
    }

    private static void topSort(List<List<Integer>> graph, List<Integer> result, int source, int destination, int[] prev) {

        Arrays.fill(visited, false);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        visited[source] = true;

        result.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            //visited[node] = true;

            if (node == destination) {
                return;
            }

            List<Integer> edges = graph.get(node);

            for (Integer child : edges) {
                child = mapIndexes.get(child);
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);

                    prev[child] = node;

                    result.add(child);
                }
            }
        }

        prev[source] = -1;

        result.clear();
    }
}
