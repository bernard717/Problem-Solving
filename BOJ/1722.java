import java.io.*;
import java.util.*;

public class Main{
    static long[] f = new long[21];
    static boolean[] c = new boolean[21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(1);
            return;
        }
        f[0]=1;
        for (int i=1; i<=20; i++) {
            f[i] = f[i-1] * i;
        }
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        int prob = Integer.parseInt(line[0]);
        long k;
        if(prob == 1){
            k = Long.parseLong(line[1]);
            for(int i = 0; i < n; i++){
                for(int j = 1; j <= n; j++){
                    if(c[j]) continue;
                    if(f[n-i-1] < k)
                        k -= f[n-i-1];
                    else{
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }

            }
            for(int i = 0; i < n; i++)
                System.out.print(a[i] + " ");
        }
        else{
            for(int start = 0; start < n; start++)
                a[start] = Integer.parseInt(line[start+1]);
            long ans = 0;
            for (int i=0; i<n; i++) {
                for (int j=1; j<a[i]; j++) {
                    if (c[j] == false) {
                        ans += f[n-i-1];
                    }
                }
                c[a[i]] = true;
            }
            System.out.println(ans + 1);
        }

    }
}
