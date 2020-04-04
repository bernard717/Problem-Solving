import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] cards = new int[n + 1];
        for(int i = 1; i <= n; i++)
            cards[i] = Integer.parseInt(line[i - 1]);

        int[] d = new int[n + 1];
        d[1] = cards[1];

        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++){
                min = Math.min(min, d[i - j] + cards[j]);
            }
            d[i] = min;
        }
        System.out.print(d[n]);
    }
}
