import java.io.*;
import java.util.*;
public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static int[] in = new int[100001];
    public static int[] post = new int[100001];
    public static int[] position = new int[100001];
    public static int search(int[] a, int num) {
        for(int i = 0; i < a.length; i++){
            if(a[i] == num)
                return i;
        }
        return -1;
    }
    public static void solve(int instart, int inend, int poststart, int postend){
        if(instart > inend || poststart > postend)
            return;
        int root = post[postend];
        sb.append(root + " ");
        int where = position[root];
        int num = where - instart;
        solve(instart, where - 1, poststart, poststart + num - 1);
        solve(where + 1, inend, poststart + num, postend - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] line1 = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(line1[i]);
            position[in[i]] = i;
        }
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            post[i] = Integer.parseInt(line2[i]);
        solve(0, n-1, 0, n-1);
        System.out.print(sb);
    }
}
