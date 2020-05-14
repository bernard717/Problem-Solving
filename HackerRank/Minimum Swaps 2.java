import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int n = arr.length;
        
        int[] next = new int[n + 1];
        for(int i = 0; i < n; i++){
            next[arr[i]] = i + 1;
        }
        boolean[] vis = new boolean[n + 1];
        int ans = 0;
        int visited = 0;
        for(int i = 1; i <= n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            visited++;
            int nex = next[i];
            while(!vis[nex]){
                ans++;
                vis[nex] = true;
                visited++;
                nex = next[nex];
            }
            if(visited == n)
                break;
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
