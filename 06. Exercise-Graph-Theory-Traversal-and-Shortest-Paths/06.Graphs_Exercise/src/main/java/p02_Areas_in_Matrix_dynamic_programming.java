import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p02_Areas_in_Matrix_dynamic_programming {
    public static class Edge {
        int[] source;
        int[] dest;

        Edge(int sRow, int sCol, int dRow, int dCol) {
            this.source = new int[]{sRow, sCol};
            this.dest = new int[]{dRow, dCol};
        }

    }

    public static List<Edge> graph = new ArrayList<>();

    public static char[][] matrix;
    public static boolean[][] visited;
    public static boolean[] visitedNode;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];

        }


        Map<Character, Integer> resultMap = new TreeMap<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col]) {

                    visited[row][col] = true;
                    char currentChar = matrix[row][col];

//                    resultMap.putIfAbsent(currentChar, 0);
//                    resultMap.put(currentChar, resultMap.get(currentChar) + 1);
//                    bfs(row, col, currentChar);



                    dfs(row, col, currentChar);

                }
            }
        }


        visitedNode = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedNode[i]) {
                Edge edge = graph.get(i);
                char key = matrix[edge.source[0]][edge.source[1]];
                resultMap.putIfAbsent(key, 0);
                resultMap.put(key, resultMap.get(key) + 1);
                bfsGraph(1);
            }
        }


        int numberOfAreas = resultMap.values().stream().mapToInt(i -> i).sum();

        System.out.println("Areas: " + numberOfAreas);

        for (Map.Entry<Character, Integer> currentArea : resultMap.entrySet()) {
            System.out.printf("Letter '%s' -> %d\n", currentArea.getKey(), currentArea.getValue());
        }
    }

    private static void bfsGraph(int source) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        visitedNode[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            Edge edge = graph.get(node);
            if(edge.dest != null){
                visitedNode[node + 1] = true;
                queue.offer(node + 1);
            }
        }
    }

    private static void dfs(int row, int col, char charToFind) {
//        if(checkIfValid(row, col) || (matrix[row + 1][col] != charToFind)){
//            return;
//        }

        visited[row][col] = true;

        if (checkIfValid(row + 1, col) && !visited[row + 1][col]) {
            if (matrix[row + 1][col] == charToFind) {
//                visited[row + 1][col] = true;
                graph.add(new Edge(row, col, row + 1, col));
                dfs(row + 1, col, charToFind);
            }
        }


        if (checkIfValid(row, col + 1) && !visited[row][col + 1]) {
            if (matrix[row][col + 1] == charToFind) {
//                visited[row][col + 1] = true;
                graph.add(new Edge(row, col, row, col + 1));
                dfs(row, col + 1, charToFind);
            }
        }


        if (checkIfValid(row - 1, col) && !visited[row - 1][col]) {
            if (matrix[row - 1][col] == charToFind) {
//                visited[row - 1][col] = true;
                graph.add(new Edge(row, col, row - 1, col));
                dfs(row - 1, col, charToFind);
            }
        }


        if (checkIfValid(row, col - 1) && !visited[row][col - 1]) {
            if (matrix[row][col - 1] == charToFind) {
//                visited[row][col - 1] = true;
                graph.add(new Edge(row, col, row, col - 1));
                dfs(row, col - 1, charToFind);
            }
        }

    }

    private static void bfs(int row, int col, char charToFind) {
        if (checkIfValid(row + 1, col) && !visited[row + 1][col]) {
            if (matrix[row + 1][col] == charToFind) {
                visited[row + 1][col] = true;
                bfs(row + 1, col, charToFind);
            }
        }


        if (checkIfValid(row, col + 1) && !visited[row][col + 1]) {
            if (matrix[row][col + 1] == charToFind) {
                visited[row][col + 1] = true;
                bfs(row, col + 1, charToFind);
            }
        }


        if (checkIfValid(row - 1, col) && !visited[row - 1][col]) {
            if (matrix[row - 1][col] == charToFind) {
                visited[row - 1][col] = true;
                bfs(row - 1, col, charToFind);
            }
        }


        if (checkIfValid(row, col - 1) && !visited[row][col - 1]) {
            if (matrix[row][col - 1] == charToFind) {
                visited[row][col - 1] = true;
                bfs(row, col - 1, charToFind);
            }
        }
    }

    private static boolean checkIfValid(int row, int col) {
        return row < matrix.length && row >= 0 && col < matrix[row].length && col >= 0;
    }
}
