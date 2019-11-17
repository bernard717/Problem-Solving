import java.io.*;
import java.util.*;
public class Main{
    static int ans = 0;
    public static int go(int[] a, int m, int i, int sum) {
        if (i == a.length) {
            if (sum == m) {
                return 1;
            } else {
                return 0;
            }
        }
        return go(a, m, i+1, sum+a[i]) + go(a, m, i+1, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int[] a = new int[n];
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line2[i]);
        int ans = go(a, s, 0, 0);
        if(s == 0){
            ans--;
        }
        System.out.println(ans); 
    }
}
