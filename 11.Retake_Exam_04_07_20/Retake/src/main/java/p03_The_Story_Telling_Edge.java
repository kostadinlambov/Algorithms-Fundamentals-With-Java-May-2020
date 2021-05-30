import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p03_The_Story_Telling_Edge {
    public static class Edge {
        public String parent;
        public String child;

        public Edge(String parent, String child) {
            this.parent = parent;
            this.child = child;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Edge> graph = new ArrayList<>();

        String line = reader.readLine();
        while (!"End".equals(line)) {

            String[] currentToken = line.split(" -> ");
            String currentParent = currentToken[0];
            String children = "";

            if(currentToken.length > 1){
                children = currentToken[1];
            }

            if (children != null) {
                String[] childrenArr = children.split("\\s+");

                for (String currentChild : childrenArr) {
                    Edge edge = new Edge(currentParent, currentChild);
                    graph.add(edge);
                }

            }

            line = reader.readLine();
        }

        System.out.println();

    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()){
            String key = graph.keySet()
                    .stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if(key == null) {
                break;
            }

            for (String child : graph.get(key)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(key);
            graph.remove(key);

        }

        // Check if graph is Empty. If not the graph has at least ONE CYCLE and we throw Exception
        if(!graph.isEmpty()){
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {

        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);

            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }


        }

        return dependenciesCount;
    }
}
