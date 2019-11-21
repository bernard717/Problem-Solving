import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());
        for(int i = n-1; i >= 0; i--){
            int temp = k / a[i];
            if(temp > 0){
                sum += temp;
                k %= a[i];
            }
        }
        System.out.println(sum);
    }
}
