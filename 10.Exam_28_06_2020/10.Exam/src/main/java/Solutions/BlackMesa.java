package Solutions;

import java.util.*;

public class BlackMesa {
    private static int nodeCount;
    private static int edgeCount;
    private static int start;
    private static int end;
    private static List<List<Integer>> graph;
    private static List<String> path;
    private static Set<Integer> visited;

    public static void main(String[] args) {
        readInput();

        bfs(start);

        printResult();
    }

    private static void printResult() {
        StringBuilder output = new StringBuilder();
        if (visited.size() < nodeCount) {
            for (int i = 1; i <= nodeCount; i++) {
                if (!visited.contains(i)) {
                    output.append(i).append(" ");
                }
            }
        }

        System.out.println(String.join(" ", path));
        System.out.println(output.toString().trim());
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        nodeCount = Integer.parseInt(scanner.nextLine().trim());
        edgeCount = Integer.parseInt(scanner.nextLine().trim());

        path = new ArrayList<>();
        visited = new HashSet<>();

        graph = new ArrayList<>();

        for (int i = 0; i < nodeCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int[] tokens = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(tokens[0]).add(tokens[1]);
        }

        start = Integer.parseInt(scanner.nextLine().trim());
        end = Integer.parseInt(scanner.nextLine().trim());
    }

    private static void bfs(int node) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited.add(node);

        boolean isFound = false;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            if (!isFound) {
                path.add(String.valueOf(parent));
                isFound = parent == end;
            }

            for (int child : graph.get(parent)) {
                if (!visited.contains(child)) {
                    queue.offer(child);
                    visited.add(child);
                }
            }
        }
    }
}
