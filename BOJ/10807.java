import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[201];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[Integer.parseInt(line[i]) + 100]++;
        int what = Integer.parseInt(br.readLine());
        System.out.println(a[what+100]);
    }
}
