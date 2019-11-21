import java.io.*;
import java.util.*;
public class Main{
    public static long count(long[] a, long k){
        int last = 0;
        long cnt = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] - a[last] >= k){
                cnt++;
                last = i;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        long[] a = new long[n];

        for(int i = 0; i < n; i++)
            a[i] = Long.valueOf(br.readLine());
        Arrays.sort(a);
        long left = 1;
        long right = a[n-1] - a[0];
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
