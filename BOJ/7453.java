import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static int[] a = new int[4001];
    static int[] b = new int[4001];
    static int[] c = new int[4001];
    static int[] d = new int[4001];
    static int[] mid1 = new int[16000001];
    static int[] mid2 = new int[16000001];
    static int lower_idx(int target, int len){
        int start = 0;
        int end = len;
        while(start < end){
            int mid = (start + end) / 2;
            if(mid1[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    static int upper_idx(int target, int len){
        int start = 0;
        int end = len;
        while(start < end){
            int mid = (start + end) / 2;
            if(mid1[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]);
            b[i] = Integer.parseInt(line[1]);
            c[i] = Integer.parseInt(line[2]);
            d[i] = Integer.parseInt(line[3]);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                mid1[i * n + j] = a[i] + b[j];
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                mid2[i * n + j] = c[i] + d[j];
        }
        Arrays.sort(mid1, 0, n * n);
        long count = 0;
        for(int i = 0; i < n * n; i++)
            count += upper_idx(-mid2[i], n * n) - lower_idx(-mid2[i], n * n);
        System.out.println(count);
    }
}
