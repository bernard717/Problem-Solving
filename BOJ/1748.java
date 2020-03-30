import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int N = Integer.parseInt(line);

        // N의 자리수
        int k = line.length();

        int ans = 0;

        for(int i = 1; i < k; i++){
            ans += i * (Math.pow(10, i) - Math.pow(10, i - 1));
        }
        ans += k * (N - Math.pow(10, k - 1) + 1);

        System.out.print(ans);
    }
}
