import java.io.*;
import java.util.*;
public class Main{
    public static int count(long[] a, long k){
        int ans = 0;
        for(int i = 0; i < a.length; i++)
            ans += a[i] / k;
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        long[] a = new long[n];
        long left = 1;
        long right = 0;
        for(int i = 0; i < n; i++){
            a[i] = Long.valueOf(br.readLine());
            if(right < a[i])
                right = a[i];
        }
        long ans = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            if(count(a, mid) >= k){
                ans = Math.max(mid, ans);
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        System.out.print(ans);
    }
}
