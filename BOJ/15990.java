import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        int N = 1000000009;

        long[][] d = new long[100001][4];

        d[1][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;

        for(int i = 4; i <= 100000; i++){
            d[i][1] = (d[i - 1][2] + d[i - 1][3]) % N;
            d[i][2] = (d[i - 2][1] + d[i - 2][3]) % N;
            d[i][3] = (d[i - 3][1] + d[i - 3][2]) % N;
        }

        for(int i = 0; i < test; i++){
            int what = Integer.parseInt(br.readLine());
            long sum = (d[what][1] % N + d[what][2] % N + d[what][3] % N) % N;

            System.out.println(sum);
        }
    }
}
