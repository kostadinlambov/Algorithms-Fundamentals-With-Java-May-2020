import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p02_Areas_in_Matrix {
    public static char[][] matrix;
    public static boolean[][] visited;

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

                    resultMap.putIfAbsent(currentChar, 0);
                    resultMap.put(currentChar, resultMap.get(currentChar) + 1);
                    bfs(row, col, currentChar);
                }
            }
        }

        int numberOfAreas = resultMap.values().stream().mapToInt(i -> i).sum();

        System.out.println("Areas: " + numberOfAreas);

        for (Map.Entry<Character, Integer> currentArea : resultMap.entrySet()) {
            System.out.printf("Letter '%s' -> %d\n", currentArea.getKey(), currentArea.getValue());
        }
    }

    private static void bfs(int row, int col, char charToFind) {
        if (checkIfValid(row + 1, col) && !visited[row + 1][col]) {
            char currentChar = matrix[row][col];
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
