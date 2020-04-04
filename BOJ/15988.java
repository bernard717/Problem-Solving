import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        int N = 1000000009;

        long[] d = new long[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for(int i = 0; i < test; i++){
            int what = Integer.parseInt(br.readLine());
            for(int j = 4; j <= what; j++){
                if(d[j] != 0) continue;
                d[j] = d[j - 1] % N + d[j - 2] % N + d[j - 3] % N;
            }
            System.out.println(d[what] % N);
        }

    }
}
