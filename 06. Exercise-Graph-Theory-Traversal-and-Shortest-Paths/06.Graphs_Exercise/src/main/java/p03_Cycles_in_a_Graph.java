import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p03_Cycles_in_a_Graph {
    public static Map<String, List<String>> graph = new HashMap<>();
    public static List<String> cycleNodes = new ArrayList<>();
    public static List<String> visitedNodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (!"End".equals(line)) {

            String[] input = line.split("-");
            String sourceNode = input[0];
            String destinationNode = input[1];

            graph.putIfAbsent(sourceNode, new ArrayList<>());
            graph.get(sourceNode).add(destinationNode);

            line = reader.readLine();
        }

        try {
            for (Map.Entry<String, List<String>> node : graph.entrySet()) {
                dfs(node.getKey());
            }

            System.out.println("Acyclic: Yes");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dfs(String source) {
        if (cycleNodes.contains(source)) {
            throw new IllegalArgumentException("Acyclic: No");
        }

        if (visitedNodes.contains(source)) {
            return;
        }

        cycleNodes.add(source);
        visitedNodes.add(source);

        List<String> children = graph.get(source);

        if (children == null || children.size() == 0) {
            return;
        }

        for (String child : children) {
            dfs(child);
        }

        cycleNodes.remove(source);
    }
}
