import java.util.*;
import java.io.*;
public class Main {
    static int[] parent = new int[1000001];
    public static void Union(int x, int y){
        x = Find(x);
        y = Find(y);
        parent[y] = x;
    }
    public static int Find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = Find(parent[x]);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int k = 1; k <= n; k++)
            parent[k] = k;
        for(int i = 0; i < m; i++){
            String[] line2 = br.readLine().split(" ");
            int x = Integer.parseInt(line2[0]);
            int y = Integer.parseInt(line2[1]);
            Union(x, y);
        }
        int ans = 0;
        for(int i = 2; i <= n; i++){
            if(Find(1) == Find(i))
                ans++;
        }
        System.out.println(ans);
    }
}
