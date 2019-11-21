import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line[i]);
        boolean judge = true;
        for(int i = 0; i < n; i++){
            if(a[i] != n - i)
                judge = false;
        }
        if(judge){
            System.out.println(-1);
            return;
        }
        int i;
        for(i = n - 1; i >= 1; i--){
            if(a[i] > a[i - 1])
                break;
        }
        int j;
        for(j = n - 1; j >= i; j--){
            if(a[j] > a[i - 1])
                break;
        }
        int temp;
        temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < i; k++)
            sb.append(a[k] + " ");
        for(int k = n - 1; k >= i; k--)
            sb.append(a[k] + " ");
        System.out.println(sb);
    }
}
