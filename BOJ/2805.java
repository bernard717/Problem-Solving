import java.io.*;
import java.util.*;
public class Main{
    public static long count(long[] a, long k){
        long ans = 0;
        for(int i = 0; i < a.length; i++) {
            long diff = a[i] - k > 0 ? a[i] - k : 0;
            ans += diff;
        }
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
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            a[i] = Long.valueOf(line2[i]);
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
