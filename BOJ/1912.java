import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        int[] d = new int[n];
        d[0] = arr[0];
        for(int i = 1; i < n; i++)
            d[i] = Math.max(d[i - 1] + arr[i], arr[i]);
        int ans = d[0];
        for(int i = 1; i < n; i++)
            ans = Math.max(ans, d[i]);
        System.out.println(ans);
    }
}
