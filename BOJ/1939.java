import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main{
    static ArrayList<Pair>[] a;
    static boolean[] check;
    static int start, end;
    public static class Pair{
        int to;
        int weight;
        Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static boolean bfs(int start, int limit){
        if(check[start])
            return false;
        Queue<Integer> queue = new LinkedList<Integer>();
        check[start] = true;
        if(start == end)
            return true;
        queue.add(start);
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(Pair y : a[x]){
                int to = y.to;
                int weight = y.weight;
                if(weight >= limit){
                    if(bfs(to, limit))
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        a = (ArrayList<Pair>[]) new ArrayList[n+1];
        check = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            a[i] = new ArrayList<Pair>();
        for(int i = 0; i < m; i++){
            String[] line2 = br.readLine().split(" ");
            a[Integer.valueOf(line2[0])].add(new Pair(Integer.valueOf(line2[1]), Integer.valueOf(line2[2])));
            a[Integer.valueOf(line2[1])].add(new Pair(Integer.valueOf(line2[0]), Integer.valueOf(line2[2])));
        }
        String[] line3 = br.readLine().split(" ");
        start = Integer.parseInt(line3[0]);
        end = Integer.parseInt(line3[1]);

        int left = 1;
        int right = 1000000000;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            for(int z = 0; z < check.length; z++)
                check[z] = false;
            if(bfs(start, mid)){
                ans = Math.max(mid, ans);
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        System.out.print(ans);
    }
}
