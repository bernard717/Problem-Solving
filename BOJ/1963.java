import java.io.*;
import java.util.*;

public class Main{
    public static int change(int num, int x, int y){
        if(x == 0 && y == 0)
            return -1;
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(x, (char)(y + '0'));
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        boolean[] judge = new boolean[10001];
        for(int i = 2; i <= 10000; i++){
            if(!judge[i]){
                for(int j = i * i; j <= 10000; j+=i)
                    judge[j] = true;
            }
        }
        for (int i=0; i<=10000; i++) {
            judge[i] = !judge[i];
        }
        while(test-- > 0){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int last = Integer.parseInt(line[1]);
            boolean[] check = new boolean[10001];
            int[] dist = new int[10001];
            check[start] = true;
            dist[start] = 0;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(start);
            while(!q.isEmpty()) {
                int nowone = q.remove();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 10; j++) {
                        int now = change(nowone, i, j);
                        if (now != -1) {
                            if (!check[now] && judge[now]) {
                                check[now] = true;
                                q.add(now);
                                dist[now] = dist[nowone] + 1;
                            }
                        }
                    }
                }
            }
            if(!check[last])
                System.out.println("Impossible");
            else
                System.out.println(dist[last]);
        }
    }
}
