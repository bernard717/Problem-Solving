import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);

        boolean[] visited = new boolean[2000001];

        for(int i = 1; i < Math.pow(2, n); i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if((i & 1 << j) == 1 << j)
                    sum += arr[j];
            }
            visited[sum] = true;
        }
        for(int i = 1; i < 2000001; i++){
            if(!visited[i]){
                System.out.print(i);
                return;
            }
        }
    }
}
