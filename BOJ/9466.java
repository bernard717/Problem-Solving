import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static int[] a, state;
    public static void dfs(int n, int j){
        if(state[n] == 0){
            state[n] = j;
            dfs(a[n], j);
        }
        else if(state[n] == j){
            state[n] = -1;
            dfs(a[n], j);
        }
        else if(state[n] == -1)
            return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            a = new int[n + 1];
            state = new int[n + 1];
            for(int j = 1; j <= n; j++)
                a[j] = Integer.parseInt(line[j - 1]);
            for(int j = 1; j <= n; j++) {
                if(state[j] == 0)
                    dfs(j, j);
            }
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(state[j] == -1)
                    count++;
            }
            System.out.println(n - count);
        }

    }
}
