import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p06_Molecules_second {
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        graph = new int[n + 1][ n + 1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= m; i++) {
            int[] ints = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            graph[ints[0]][ints[1]] = 1;
        }

        int start = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int node = queue.poll();

            visited[node] = true;

            for (int i = 0; i < graph.length; i++) {
                int hasConnection = graph[node][i];

                if(hasConnection == 1 && !visited[i] ){
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {

            if(!visited[i]){
                System.out.print(i + " ");
            }
        }
    }
}
