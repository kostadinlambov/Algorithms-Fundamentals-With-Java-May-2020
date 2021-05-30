import jdk.nashorn.api.tree.LiteralTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p03_The_Story_Telling {
    public static Map<String, Integer> orderOfInput = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> graph = new LinkedHashMap<>();

//        Map<String, List<String>> graph = new HashMap<>();

        int counter = 1;
        String line = reader.readLine();
        while (!"End".equals(line)) {

            String[] currentToken = line.split("\\s+->\\s*");
            String currentParent = currentToken[0];

            graph.putIfAbsent(currentParent, new ArrayList<>());
            orderOfInput.putIfAbsent(currentParent, counter);
            counter++;
            if (currentToken.length > 1) {
                String children = currentToken[1];

                String[] childrenArr = children.split("\\s+");

                for (String currentChild : childrenArr) {
                    graph.get(currentParent).add(currentChild);

                }
            }

            line = reader.readLine();
        }

        Collection<String> strings = topSort(graph);

        for (String string : strings) {
            System.out.print(string + " ");
        }

        System.out.println();
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
//            String key = graph.keySet()
//                    .stream()
//                    .filter(k -> dependenciesCount.get(k) == 0)
//                    .findFirst()
//                    .orElse(null);

            String key = null;
//
            List<String> possibleNextKey = new ArrayList<>();

            for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
                if (dependenciesCount.get(entry.getKey()) == 0) {
                    key = entry.getKey();
                    possibleNextKey.add(key);
                }
            }

            possibleNextKey.sort((a, b) -> {

                List<String> firstList = graph.get(a);
                List<String> secondList = graph.get(b);

                int firstListMinIndex = Integer.MAX_VALUE;
                int secondListMinIndex = Integer.MAX_VALUE;
                ;

//                if (firstList.size() > 0) {
//                    String firstListFirstElement = firstList.get(0);
//                    firstListMinIndex = orderOfInput.get(firstListFirstElement);
//                }
//
//                if (secondList.size() > 0) {
//                    String secondListFirstElement = secondList.get(0);
//                    secondListMinIndex = orderOfInput.get(secondListFirstElement);
//                }
//
                for (String firstListKey : firstList) {
                    Integer inputIndex = orderOfInput.get(firstListKey);

                    if(inputIndex < firstListMinIndex){
                        firstListMinIndex = inputIndex;
                    }

                }
//
                for (String secondListKey : secondList) {
                    Integer inputIndex = orderOfInput.get(secondListKey);

                    if(inputIndex < secondListMinIndex){
                        secondListMinIndex = inputIndex;
                    }
                }

                return firstListMinIndex - secondListMinIndex;
            });

            key = possibleNextKey.get(0);

//            key = graph.keySet()
//                    .stream()
//                    .filter(k -> dependenciesCount.get(k) == 0)
//                    .findFirst()
//                    .orElse(null);
//
////            String key = graph.keySet()
////                    .stream()
////                    .filter(k -> dependenciesCount.get(k) == 0)
////                    .find()
////                    .orElse(null);

            if (key == null) {
                break;
            }

            for (String child : graph.get(key)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(key);
            graph.remove(key);

        }

//        for (String key : graph.keySet()) {
//            if (key == null) {
//                break;
//            }
//
//            for (String child : graph.get(key)) {
//                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
//            }
//
//            sorted.add(key);
////            graph.remove(key);
//        }

        // Check if graph is Empty. If not the graph has at least ONE CYCLE and we throw Exception
        if (!graph.isEmpty()) {
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
