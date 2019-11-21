import java.io.*;
import java.util.*;
public class Main{
    static StringBuilder sb = new StringBuilder();
    public static boolean next(int[] a, int n){
        int i, j;
        for(i = n - 1; i >= 1; i--){
            if(a[i] > a[i - 1])
                break;
        }
        for(j = n - 1; j >= i; j--){
            if(a[j] > a[i - 1])
                break;
        }
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        boolean judge = true;
        for(int m = 0; m < n; m++){
            if(a[m] != n - m)
                judge = false;
        }
        return !judge;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = i + 1;
        if(n == 1){
            System.out.println(1);
            return;}
        do{
            for(int i = 0; i < n; i++)
                sb.append(a[i] + " ");
            sb.append("\n");
        }while(next(a, n));
        for(int i = 0; i < n; i++)
            sb.append(a[i] + " ");
        sb.append("\n");
        System.out.println(sb);
    }
}
