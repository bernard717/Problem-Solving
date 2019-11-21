import java.util.*;
import java.io.*;

public class Main {
    static int[] a, b;
    public static int binary_search(int target, int len){
        int start = 0;
        int end = len - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(a[mid] < target)
                start = mid + 1;
            else if(a[mid] > target)
                end = mid - 1;
            else
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");
        a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line1[i]);
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");
        int[] b = new int[m];
        for(int i = 0; i < m; i++)
            b[i] = Integer.parseInt(line2[i]);
        for(int i = 0; i < m; i++)
            System.out.println(binary_search(b[i], a.length));
    }
}
