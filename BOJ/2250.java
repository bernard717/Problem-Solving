import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int[] lc, rc, row, col, parent;
    static int idx;
    static ArrayList<Integer>[] levels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        lc = new int[n + 1];
        rc = new int[n + 1];
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++){
            String[] line = br.readLine().split(" ");
            int now = Integer.parseInt(line[0]);
            int left = Integer.parseInt(line[1]);
            int right = Integer.parseInt(line[2]);
            if(left != -1) {
                lc[now] = left;
                parent[left] = now;
            }
            if(right != -1) {
                rc[now] = right;
                parent[right] = now;
            }
        }
        int root = -1;
        for(int i = 1; i <= n; i++){
            if(parent[i] == 0) {
                root = i;
                break;
            }
        }

        col = new int[n + 1];
        row = new int[n + 1];
        idx = 1;

        levels = new ArrayList[10001];
        for(int i = 0; i < 10001; i++)
            levels[i] = new ArrayList<>();

        inorder(root, 1);

        int max = Integer.MIN_VALUE;
        int maxDepth = -1;

        for(int i = 0; i < 10001; i++){
            if(levels[i].size() == 0) continue;
            Collections.sort(levels[i]);
            if(max < levels[i].get(levels[i].size() - 1) - levels[i].get(0) + 1){
                max = levels[i].get(levels[i].size() - 1) - levels[i].get(0) + 1;
                maxDepth = i;
            }
        }
        System.out.print(maxDepth + " " + max);
    }
    static void inorder(int node, int depth){
        // 왼쪽에 자식노드가 있는 경우
        if(lc[node] != 0)
            inorder(lc[node], depth + 1);
        col[node] = idx;
        levels[depth].add(idx++);
        if(rc[node] != 0)
            inorder(rc[node], depth + 1);
    }
}
