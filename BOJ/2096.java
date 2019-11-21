import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 3; j++)
                a[i][j] = Integer.parseInt(line[j]);
        }
        int[][] dMax = new int[n][3];
        int[][] dMin = new int[n][3];
        dMax[0][0] = a[0][0];
        dMax[0][1] = a[0][1];
        dMax[0][2] = a[0][2];
        dMin[0][0] = a[0][0];
        dMin[0][1] = a[0][1];
        dMin[0][2] = a[0][2];
        for(int i = 1; i < n; i++){
            dMax[i][0] = Math.max(dMax[i - 1][0], dMax[i - 1][1]) + a[i][0];
            dMax[i][1] = Math.max(Math.max(dMax[i - 1][0], dMax[i - 1][1]), dMax[i - 1][2]) + a[i][1];
            dMax[i][2] = Math.max(dMax[i - 1][1], dMax[i - 1][2]) + a[i][2];
        }
        for(int i = 1; i < n; i++){
            dMin[i][0] = Math.min(dMin[i - 1][0], dMin[i - 1][1]) + a[i][0];
            dMin[i][1] = Math.min(Math.min(dMin[i - 1][0], dMin[i - 1][1]), dMin[i - 1][2]) + a[i][1];
            dMin[i][2] = Math.min(dMin[i - 1][1], dMin[i - 1][2]) + a[i][2];
        }
        int max = Math.max(Math.max(dMax[n-1][0], dMax[n-1][1]), dMax[n-1][2]);
        int min = Math.min(Math.min(dMin[n-1][0], dMin[n-1][1]), dMin[n-1][2]);
        System.out.println(max + " " + min);
    }
}
