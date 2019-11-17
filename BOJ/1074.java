import java.io.*;
import java.util.*;
public class Main{
    public static char[][] a;
    public static StringBuilder sb = new StringBuilder();
    public static int pow(int x, int n){
        for(int i = 1; i < n; i++)
            x *= 2;
        return x;
    }
    public static int solve(int n, int x, int y){
        if(n == 1)
            return 2 * x + y;
        else{
            if(x < pow(2, n - 1)){
                if(y < pow(2, n - 1))
                    return solve(n - 1, x, y);
                else
                    return solve(n - 1, x, y - pow(2, n - 1)) + pow(2, 2*n-2);
            }
            else{
                if(y < pow(2, n - 1))
                    return solve(n - 1, x - pow(2, n - 1), y) + pow(2, 2*n-2) * 2;
                else
                    return solve(n - 1, x - pow(2, n - 1), y - pow(2, n - 1)) + pow(2, 2*n-2) * 3;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        int ans = solve(n, r, c);


        System.out.print(ans); 
    }
}
