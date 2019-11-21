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
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        for(int k = 0; k <= n; k++)
            parent[k] = k;
        for(int i = 0; i < m; i++){
            String[] line2 = br.readLine().split(" ");
            int what = Integer.parseInt(line2[0]);
            int x = Integer.parseInt(line2[1]);
            int y = Integer.parseInt(line2[2]);
            if(what == 0)
                Union(x, y);
            else{
                int x1 = Find(x);
                int y1 = Find(y);
                if(x1 == y1)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
