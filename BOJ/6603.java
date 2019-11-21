import java.io.*;
import java.util.*;
public class Main{
    static char[][] a;
    static boolean[] check;
    static int r, c;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void go(int[] a, int index, int left, int n, String s){
        if(left == 0) {
            System.out.println(s);
            return;
        }
        if(index < n){
        go(a, index + 1, left - 1, n, s + a[index] + " ");
        go(a, index + 1, left, n, s);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            if(n == 0)
                break;
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(line[i + 1]);
            go(a, 0, 6, n, "");
            System.out.println();

        }
    }
}
