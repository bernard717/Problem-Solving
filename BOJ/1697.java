import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        final int MAX = 200000;
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] check = new boolean[MAX+1];
        int[] dist = new int[MAX+1];
        q.add(n);
        check[n] = true;
        while(!q.isEmpty()){
            int now = q.remove();
            if(now - 1 >= 0){
                if(!check[now-1]){
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                    q.add(now-1);
                }
            }
            if(now + 1 <= MAX){
                if(!check[now+1]){
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                    q.add(now + 1);
                }
            }
            if(now * 2 <= MAX){
                if(!check[now * 2]){
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1;
                    q.add(now * 2);
                }
            }
        }
        System.out.println(dist[k]);
    }
}
