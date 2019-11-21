import java.util.*;
import java.io.*;
public class Main {
    static int[][] a, b;
    static int ans = 0;
    static int n, m;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static boolean[][] check;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void go(int x, int y, boolean[][] check){
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(x, y));
        check[x][y] = true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            for(int k = 0; k < 4; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(a[nx][ny] == 0 && !check[nx][ny]){
                        a[nx][ny] = 2;
                        check[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
    public static boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(j >= i && a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(j > i){
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            j--;
            i++;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = new int[n][m];
        b = new int[n][m];
        int spaceNum = 0, wallNum = 0, virusNum = 0;
        for(int i = 0; i < n; i++){
            String[] line1 = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                int what = Integer.parseInt(line1[j]);
                if(what == 0)
                    spaceNum++;
                else if(what == 1)
                    wallNum++;
                else
                    virusNum++;
                a[i][j] = what;
                b[i][j] = what;
            }
        }
        int[] per = new int[spaceNum];
        for(int i = 0; i < 3; i++)
            per[i] = 0;
        for(int i = 3; i < spaceNum; i++)
            per[i] = 1;
        int max = Integer.MIN_VALUE;
        do{
            ans = 0;
            int k = 0;
            for(int i = 0; i < n * m; i++){
                int x = i / m;
                int y = i % m;
                if(a[x][y] == 0){
                    if(per[k] == 0){
                        a[x][y] = 1;
                    }
                    k++;
                }
            }
            check = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j] == 2)
                        go(i, j, check);
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j] == 0)
                        ans++;
                }
            }
            max = Math.max(ans, max);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++)
                    a[i][j] = b[i][j];
            }
        }while(next(per));
        System.out.println(max);
    }
}
