import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());
        Arrays.sort(a);
        for(int i = 0; i < n; i++)
            b[i] = a[i] * (n - i);
        Arrays.sort(b);
        int ans = b[n-1];
        System.out.println(ans);

    }
}
