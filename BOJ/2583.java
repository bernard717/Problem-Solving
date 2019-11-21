import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] a;
    static boolean[][] check;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int go(int x, int y){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        check[x][y] = true;
        int num = 1;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0; k < 4; k++){
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!check[nx][ny] && a[nx][ny] == 1){
                        q.add(new Pair(nx, ny));
                        num++;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        a = new int[n][m];
        check = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                a[i][j] = 1;
        }
        for(int i = 0; i < k; i++){
            String[] line1 = br.readLine().split(" ");
            int x1 = Integer.parseInt(line1[0]);
            int y1 = Integer.parseInt(line1[1]);
            int x2 = Integer.parseInt(line1[2]);
            int y2 = Integer.parseInt(line1[3]);
            for(int j = x1; j < x2; j++){
                for(int l = y1; l < y2; l++)
                    a[j][l] = 0;
            }
        }
        ArrayList<Integer> array = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            if (a[x][y] == 1 && !check[x][y]) {
                array.add(go(x, y));
                num++;
            }
        }
        Collections.sort(array);
        System.out.println(num);
        for(int i = 0; i < num; i++)
            System.out.print(array.get(i) + " ");
        System.out.println();
    }
}
