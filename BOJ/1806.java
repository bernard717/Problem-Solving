import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(j - i + 1 >= answer)
                    break;
                if(sum >= m)
                    answer = Math.min(j - i + 1, answer);
            }
        }
        if(answer == Integer.MAX_VALUE)
            answer = 0;
        System.out.print(answer);
    }
}
