import java.io.*;
import java.util.*;

public class Main {
    public static void dfs(ArrayList<Integer>[] a, int[] c, int x, int prev) {
        if (c[x] == 1 || c[x] == 2)
            return;
        if(c[prev] == 1)
            c[x] = 2;
        else
            c[x] = 1;
        for (int y : a[x]) {
            if (c[y] == 0) {
                dfs(a, c, y, x);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = new ArrayList<Integer>();
            for (int i = 1; i <= m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }
            int[] check = new int[n + 1];
            for (int i=1; i<=n; i++) {
                if (check[i] == 0) {
                    dfs(a, check, i, 0);
                }
            }

            boolean ans = true;
            for (int i = 1; i <= n; i++) {
                for (int x : a[i]) {
                    if (check[i] == check[x])
                        ans = false;
                }
            }
            String c = ans ? "YES" : "NO";
            System.out.println(c);
        }
    }
}
