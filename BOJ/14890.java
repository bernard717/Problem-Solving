import java.util.*;
import java.io.*;
public class Main {
    static int[][] a;
    static int n, l;
    static boolean check1[][];
    static boolean check2[][];
    public static int countRight(int x, int y){
        int ans = 1;
        int what = a[x][y];
        for(int i = y + 1; i < n; i++){
            if(what == a[x][i])
                ans++;
            else
                break;
        }
        return ans;
    }
    public static int countDown(int x, int y){
        int ans = 1;
        int what = a[x][y];
        for(int i = x + 1; i < n; i++){
            if(what == a[i][y])
                ans++;
            else
                break;
        }
        return ans;
    }
    public static boolean go(int x, int y, int judge){
        if(judge == 1){
            int cnt = 1;
            int i = 0;
            while(i < n - 1){
                if((a[i][y] == a[i + 1][y]) && !check1[i + 1][y]){
                    cnt++;
                    i++;
                    continue;
                }
                else{
                    if(a[i+1][y] - a[i][y] == 1) {
                        if (cnt < l)
                            return false;
                        cnt = 1;
                        i++;
                    }
                    else if(a[i][y] - a[i+1][y] == 1){
                        if(countDown(i+1, y) < l)
                            return false;
                        else{
                            for(int j = i + 1; j <= i+l; j++)
                                check1[j][y] = true;
                            cnt = 0;
                            i += l;
                            continue;
                        }
                    }
                    else
                        return false;
                }
            }
        }
        else{
            int cnt = 1;
            int i = 0;
            while(i < n - 1) {
                if ((a[x][i] == a[x][i + 1]) && !check2[x][i + 1]) {
                    cnt++;
                    i++;
                    continue;
                } else {
                    if (a[x][i + 1] - a[x][i] == 1) {
                        if (cnt < l)
                            return false;
                        cnt = 1;
                        i++;
                    }
                    else if (a[x][i] - a[x][i + 1] == 1) {
                        if (countRight(x, i + 1) < l)
                            return false;
                        else {
                            for (int j = i + 1; j <= i + l; j++)
                                check2[x][j] = true;
                            cnt = 0;
                            i += l;
                            continue;
                        }
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        l = Integer.parseInt(line[1]);
        a = new int[n][n];
        check1 = new boolean[n][n];
        check2 = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(line2[j]);
        }
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 0; i < n; i++){
            if(go(0, i, 1))
                ans1++;
            if(go(i, 0, 2))
                ans2++;
        }
        System.out.println(ans1 + ans2);
    }
}
