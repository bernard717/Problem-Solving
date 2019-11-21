import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int[] a, b;
    public static int binary_search(int target, int len){
        int start = 0;
        int end = len - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(b[mid] < target)
                start = mid + 1;
            else if(b[mid] > target)
                end = mid - 1;
            else
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int numA = Integer.parseInt(line1[0]);
        int numB = Integer.parseInt(line1[1]);
        a = new int[numA];
        b = new int[numB];
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < numA; i++)
            a[i] = Integer.parseInt(line2[i]);
        String[] line3 = br.readLine().split(" ");
        for(int i = 0; i < numB; i++)
            b[i] = Integer.parseInt(line3[i]);
        Arrays.sort(a);
        Arrays.sort(b);
        int[] ans = new int[numA];
        int count = 0;
        for(int i = 0; i < numA; i++){
            if(Arrays.binarySearch(b, a[i]) < 0) {
                ans[count] = a[i];
                count++;
            }
        }
        System.out.println(count);
        for(int i = 0; i < count; i++)
            System.out.print(ans[i] + " ");
    }
}
