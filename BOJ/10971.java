import java.io.*;
import java.util.*;
public class Main{
    static int[][] w;
    public static boolean next(int[] a){
        int i, j;
        for(i = a.length - 1; i >= 1; i--){
            if(a[i] > a[i - 1])
                break;
        }
        if(i <= 0)
            return false;
        for(j = a.length - 1; j >= i; j--){
            if(a[j] > a[i - 1])
                break;
        }
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static int calculate(int a[]) {
        int sum = 0;
        boolean ok = true;
        for(int i = 0; i + 1 < a.length; i++) {
            if(w[a[i]][a[i + 1]] == 0)
                ok = false;
            else
                sum += w[a[i]][a[i + 1]];
        }
        if(ok && w[a[a.length - 1]][a[0]] != 0){
            sum += w[a[a.length - 1]][a[0]];
            return sum;
        }
        else
            return Integer.MAX_VALUE;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        w = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split("\\s+");
            for(int j = 0; j < n; j++)
                w[i][j] = Integer.parseInt(line[j]);
        }
        for(int i = 0; i < n; i++)
            a[i] = i;

        int ans = Integer.MAX_VALUE;
        do{
            int temp = calculate(a);
            ans = Math.min(temp, ans);
        }while(next(a));

        System.out.println(ans);
    }
}
