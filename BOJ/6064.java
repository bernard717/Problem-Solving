import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++){
            String[] s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);
            
            if(x == m)
                x = 0;
            if(y == n)
                y = 0;

            int plus, ans;
            
            // x가 y보다 크면 ans값을 m씩 증가시킴
            if(x >= y) {
                ans = x;
                plus = m;
            }
            // y가 x보다 크면 ans값을 n씩 증가시킴
            else {
                ans = y;
                plus = n;
            }
            
            // m, n의 최대공약수 찾기
            int max = 1;
            for(int j = 2; j <= m && j <= n; j++){
                if(j % m == 0 && j % n == 0)
                    max = j;
            }
            // max는 m, n의 최소공배수
            max = m * n / max;

            boolean flag = false;
            while(ans <= max){
                if(ans % m == x && ans % n == y){
                    flag = true;
                    break;
                }
                ans += plus;
            }
            if(flag)
                System.out.println(ans);
            else
                System.out.println(-1);
        }
    }
}
