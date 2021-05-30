import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p03_Black_Mesa {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfVersions = Integer.parseInt(reader.readLine());

        int connections = Integer.parseInt(reader.readLine());

        int[][] graph = new int[numberOfVersions + 1][numberOfVersions + 1];

        for (int i = 0; i < connections; i++) {
            int[] pairVersion = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[pairVersion[0]][pairVersion[1]] = 1;
        }

        int start = Integer.parseInt(reader.readLine());
        int target = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);

        boolean[] visited = new boolean[numberOfVersions +1];
        List<Integer> result = new ArrayList<>();

        StringBuilder resultSb = new StringBuilder();

        while(!queue.isEmpty()){
            int node = queue.poll();

            visited[node] = true;

//            if (node == target) {
//                resultSb.append(node).append(" ");
//                break;
//            }

////            result.add(node);
//            if(node <= target){
//                resultSb.append(node).append(" ");
//            }

            result.add(node);

            for (int i = 0; i < graph[node].length; i++) {
                if(graph[node][i] != 0 && !visited[i]){
                    queue.offer(i);
                }
            }
        }




        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        System.out.println();

        resultSb.append(System.lineSeparator());

        int counter = 0;

//        List<Integer> visitedList = new ArrayList<>();
//
//        for (int i = 1; i < visited.length; i++) {
//                visitedList.add(i);
//        }
//
//        for (Integer integer : visitedList) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();


        for (int i = 1; i < visited.length; i++) {
            if (visited[i] ) {
                counter++;
//                System.out.print((i) + " ");
                resultSb.append(i).append(" ");
            }
        }

        if(counter > 0){
            resultSb.append(System.lineSeparator());
        }


        System.out.print(resultSb.toString());

    }
}
