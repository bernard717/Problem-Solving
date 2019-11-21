import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        d[0] = 1;
        for(int i = 1; i < n; i++){
            d[i] = 1;
            for(int j = 0; j < i; j++){
                if(a[j] < a[i])
                    d[i] = Math.max(d[i], d[j] + 1);
            }
        }
        Arrays.sort(d);
        System.out.println(n - d[n-1]);
    }
}
