import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[][] a = new int[n][m];
        int[][] d = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                a[i][j] = s.charAt(j) - '0';
        }
        d[0][0] = a[0][0];
        int max = 0;
        for(int i = 0; i < n * m; i++){
            int x = i / m;
            int y = i % m;
            if(a[x][y] == 0)
                continue;
            if(x < 1 || y < 1)
                d[x][y] = 1;
            else if(d[x - 1][y - 1] == 0)
                d[x][y] = 1;
            else {
                int what = d[x - 1][y - 1];
                for(int temp = what; temp >= 1; temp--) {
                    boolean judge = true;
                    for (int j = x - temp; j < x; j++) {
                        if (a[j][y] != 1) {
                            judge = false;
                            break;
                        }
                    }
                    for (int j = y - temp; j < y; j++) {
                        if (a[x][j] != 1) {
                            judge = false;
                            break;
                        }
                    }
                    if (judge){
                        d[x][y] = temp + 1;
                        break;
                    }
                }
                if(d[x][y] < 2)
                    d[x][y] = 1;
            }
            max = Math.max(max, d[x][y]);
        }
        System.out.println(max * max);
    }
}
