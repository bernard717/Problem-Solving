import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] result;
    static char[][] sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        sign = new char[n][n];
        result = new int[n];

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++)
                sign[i][j] = s.charAt(idx++);
        }
        solve(0);
        for(int i = 0; i < n; i++)
            System.out.print(result[i] + " ");
    }
    static boolean solve(int idx){
        if(idx == n)
            return true;

        for(int i = 0; i <= 20; i++){
            result[idx] = i - 10;
            if(check(idx) && solve(idx + 1))
                return true;
        }
        return false;
    }
    static boolean check(int idx){
        int sum = 0;
        for(int i = idx; i >= 0; i--){
            sum += result[i];
            if(sign[i][idx] == '+' && sum <= 0)
                return false;
            if(sign[i][idx] == '-' && sum >= 0)
                return false;
            if(sign[i][idx] == '0' && sum != 0)
                return false;
        }
        return true;
    }
}
