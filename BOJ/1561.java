import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        if(n <= m){
            System.out.println(n);
            return;
        }
        int[] a = new int[m + 1];
        String[] line2 = br.readLine().split(" ");
        for(int i = 1; i <= m; i++)
            a[i] = Integer.parseInt(line2[i-1]);
        long left = 0;
        long right = 1000000L * 2000000000L;
        while(left <= right){
            long mid = (left + right) / 2;
            long begin, end;
            begin = 0;
            end = m;
            for(int i = 1; i <= m; i++)
                end += mid / a[i];
            begin = end;
            for(int i = 1; i<= m; i++){
                if(mid % a[i] == 0)
                    begin -= 1;
            }
            begin += 1;
            if(n < begin)
                right = mid - 1;
            else if(n > end)
                left = mid + 1;
            else{
                for(int i = 1; i <= m; i++){
                    if(mid % a[i] == 0){
                        if(n == begin){
                            System.out.println(i);
                            return;
                        }
                        begin += 1;
                    }
                }
            }
        }

    }
}
