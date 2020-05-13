import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int len = c.length;
        int[] dist = new int[len];
        for(int i = 1; i < len; i++)
            dist[i] = -1;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int now = q.remove();
            int next = now + 2;
            if(next < len && dist[next] == -1 && c[next] != 1){
                q.add(next);
                dist[next] = dist[now] + 1;
            }
            next = now + 1;
            if(next < len && dist[next] == -1 && c[next] != 1){
                q.add(next);
                dist[next] = dist[now] + 1;
            }
        }
        return dist[len - 1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
