import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[] c = new boolean[10001];
            int[] d = new int[10001];
            char[] w = new char[10001];
            int[] v = new int[10001];
            c[n] = true;
            d[n] = 0;
            v[n] = -1;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(n);
            while (!q.isEmpty()) {
                int now = q.remove();
                int next = (now*2) % 10000;
                if (c[next] == false) {
                    q.add(next);
                    c[next] = true;
                    d[next] = d[now]+1;
                    v[next] = now;
                    w[next] = 'D';
                }
                next = now-1;
                if (next == -1) next = 9999;
                if (c[next] == false) {
                    q.add(next);
                    c[next] = true;
                    d[next] = d[now]+1;
                    v[next] = now;
                    w[next] = 'S';
                }
                next = (now%1000)*10 + now/1000;
                if (c[next] == false) {
                    q.add(next);
                    c[next] = true;
                    d[next] = d[now]+1;
                    v[next] = now;
                    w[next] = 'L';
                }
                next = (now/10) + (now%10)*1000;
                if (c[next] == false) {
                    q.add(next);
                    c[next] = true;
                    d[next] = d[now]+1;
                    v[next] = now;
                    w[next] = 'R';
                }
            }
            StringBuilder ans = new StringBuilder();
            while (m != n) {
                ans.append(w[m]);
                m = v[m];
            }
            System.out.println(ans.reverse());
        }
    }
}
