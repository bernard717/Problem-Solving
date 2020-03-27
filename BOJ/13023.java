import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int people = Integer.parseInt(s[0]);
        int relations = Integer.parseInt(s[1]);

        ArrayList<Integer>[] lists = new ArrayList[people];
        for(int i = 0; i < people; i++)
            lists[i] = new ArrayList<>();

        for(int i = 0; i < relations; i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            lists[a].add(b);
            lists[b].add(a);
        }
        for(int i = 0; i < people; i++){
            int[] depth = new int[people];
            for(int j = 0; j < people; j++)
                depth[j] = -1;
            depth[i] = 0;
            dfs(lists, depth, i);
        }
        System.out.print("0");
    }
    public static void dfs(ArrayList<Integer>[] lists, int[] depth, int n){
        if(depth[n] == 4) {
            System.out.print("1");
            System.exit(0);
        }
        for(int next : lists[n]){
            if(depth[next] != -1) continue;
            depth[next] = depth[n] + 1;
            dfs(lists, depth, next);
            depth[next] = -1;
        }
    }
}
