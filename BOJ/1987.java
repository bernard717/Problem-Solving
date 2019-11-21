import java.io.*;
import java.util.*;

public class Main{
    static char[][] a;
    static boolean[] check;
    static int r, c;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int go(int x, int y){
        int ans = 0;
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c){
                if(!check[a[nx][ny] - 'A']){
                    check[a[nx][ny] - 'A'] = true;
                    int next = go(nx, ny);
                    if(next > ans)
                        ans = next;
                    check[a[nx][ny] - 'A'] = false;
                }
            }
        }
        return ans + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        a = new char[r][c];
        check = new boolean[26];
        for(int i = 0; i < r; i++){
            String line2 = br.readLine();
            for(int j = 0; j < c; j++)
                a[i][j] = line2.charAt(j);
        }
        check[a[0][0] - 'A'] = true;
        System.out.println(go(0, 0));

    }
}
