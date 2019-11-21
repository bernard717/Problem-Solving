import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line[i]);
        
        for(int i = 0; i < n; i++){
            d[i] = 1;
            for(int j = 0; j < i; j++){
                if(a[i] > a[j])
                    d[i] = Math.max(d[i], d[j] + 1);
            }
        }
        Arrays.sort(d);
        System.out.println(d[n - 1]);
    }
}
