//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class p03_Black_Mesa_old {
//    public static boolean[] visited;
//    public static int[] prevNodes;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int numberOfVersions = Integer.parseInt(reader.readLine());
//
//        int connections = Integer.parseInt(reader.readLine());
//
//        List<List<Integer>> graph = new ArrayList<>();
//
//        for (int i = 0; i < n + 1; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        int[][] graph = new int[numberOfVersions + 1][numberOfVersions + 1];
//
//        for (int i = 0; i < connections; i++) {
//            int[] pairVersion = Arrays.stream(reader.readLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//
//            graph[pairVersion[0]][pairVersion[1]] = 1;
//        }
//
//        int source = Integer.parseInt(reader.readLine());
//        int destination = Integer.parseInt(reader.readLine());
//
//        visited = new boolean[numberOfVersions + 1];
//        prevNodes = new int[numberOfVersions + 1];
//
//        Arrays.fill(prevNodes, -1);
//
//        bfs(graph, source, destination);
//
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        queue.offer(start);
//
//        boolean[] visited = new boolean[numberOfVersions + 1];
//        List<Integer> result = new ArrayList<>();
//
//        while (!queue.isEmpty()) {
//            int node = queue.poll();
//
//            visited[node] = true;
//
//            result.add(node);
//
//            for (int i = 0; i < graph[node].length; i++) {
//                if (graph[node][i] != 0 && !visited[i]) {
//                    queue.offer(i);
//                }
//            }
//        }
//
//
//        for (Integer integer : result) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();
//
//        for (int i = 1; i < visited.length; i++) {
//            if (!visited[i]) {
//                System.out.print((i) + " ");
//            }
//        }
//
//
//    }
//
//    private static void bfs(List<List<Integer>> graph, int source, int destination) {
//
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        queue.offer(source);
//        visited[source] = true;
//
//        while (!queue.isEmpty()) {
//            int node = queue.poll();
//
//            if (node == destination) {
//                return;
//            }
//
//            for (int child : graph.get(node)) {
//                if (!visited[child]) {
//                    visited[child] = true;
//                    prevNodes[child] = node;
//                    queue.offer(child);
//                }
//            }
//        }
//    }
//
//
//}
