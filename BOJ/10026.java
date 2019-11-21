import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static int[][] a, b;
    static boolean[][] checkA, checkB;
    static int n;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void go(int x, int y, int what, int which){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        if(which == 0)
            checkA[x][y] = true;
        else
            checkB[x][y] = true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0; k < 4; k++){
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(which == 0){
                        if(!checkA[nx][ny] && a[nx][ny] == what){
                            q.add(new Pair(nx, ny));
                            checkA[nx][ny] = true;
                        }
                    }
                    else {
                        if(!checkB[nx][ny] && b[nx][ny] == what){
                            q.add(new Pair(nx, ny));
                            checkB[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        b = new int[n][n];
        checkA = new boolean[n][n];
        checkB = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                if(s.charAt(j) == 'R'){
                    a[i][j] = 0;
                    b[i][j] = 0;
                }
                else if(s.charAt(j) == 'G'){
                    a[i][j] = 1;
                    b[i][j] = 0;
                }
                else {
                    a[i][j] = 2;
                    b[i][j] = 1;
                }
            }
        }
        int numA = 0;
        int numB = 0;
        for(int i = 0; i < n * n; i++){
            int x = i / n;
            int y = i % n;
            if(!checkA[x][y]) {
                go(x, y, a[x][y], 0);
                numA++;
            }
            if(!checkB[x][y]) {
                go(x, y, b[x][y], 1);
                numB++;
            }
        }
        System.out.println(numA + " " + numB);
    }
}
