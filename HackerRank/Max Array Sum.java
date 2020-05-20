import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int n = arr.length;

        int[] d = new int[n];

        d[0] = arr[0];
        d[1] = arr[1];
        d[2] = arr[2] > 0 ? Math.max(arr[2], arr[2] + d[0]) : d[0];

        int max = Integer.MIN_VALUE;

        for(int i = 3; i < n; i++){
            int tempMax = Math.max(d[i - 2], d[i - 3]);
            if(arr[i] > 0)
                d[i] = Math.max(arr[i], tempMax + arr[i]);
            else
                d[i] = tempMax;
            max = Math.max(max, d[i]);
        }
        
        return max;
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

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
