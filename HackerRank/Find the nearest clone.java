import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */

    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, int[] ids, int val) {
        adj = new ArrayList[graphNodes + 1];
        for(int i = 0; i <= graphNodes; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < graphFrom.length; i++){
            int from = graphFrom[i];
            int to = graphTo[i];
            adj[from].add(to);
            adj[to].add(from);
        }
        // 시작점을 두는 큐
        ArrayList<Integer> start = new ArrayList<>();

        for(int i = 0; i < ids.length; i++){
            int color = ids[i];
            // 찾고자 하는 색이랑 같은 경우
            if(color == val)
                start.add(i + 1);
        }

        for(int st : start){
            visited = new boolean[graphNodes + 1];
            visited[st] = true;
            dfs(st, 0, val, ids);
        }
        if(min == Integer.MAX_VALUE)
            min = -1;
        return min;
    }
    public static void dfs(int st, int len, int finding, int[] ids) {
        for(int dst : adj[st]){
            if(visited[dst]) continue;
            if(ids[dst - 1] == finding)
                min = Math.min(len + 1, min);
            visited[dst] = true;
            dfs(dst, len + 1, finding, ids);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        int[] ids = new int[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            int idsItem = Integer.parseInt(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
