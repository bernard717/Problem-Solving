import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static long road, lib;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0; i < cities.length; i++){
            int from = cities[i][0];
            int to = cities[i][1];
            arr[from].add(to);
            arr[to].add(from);
        }

        visited = new boolean[n + 1];

        road = 0;
        lib = 0;

        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            lib++;
            dfs(i);
        }
        System.out.println("c_road: " + road + "c_lib:" + lib);
        System.out.println("----");
        long ans = (long)c_lib * lib + (long)c_road * road;
        
        return Math.min(ans, (long)c_lib * n);
    }
    public static void dfs(int start){
        for(int dst : arr[start]){
            if(visited[dst]) continue;
            visited[dst] = true;
            road++;
            System.out.println(dst);
            dfs(dst);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
