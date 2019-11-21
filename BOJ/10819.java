import java.io.*;
import java.util.*;
public class Main{
    public static int[] fact = {0, 1, 2, 6, 24, 120, 720, 5040, 40320};
    static int n;
    public static boolean next(int[] a, int num){
        if(num == fact[n] + 1)
            return false;
        int i, j;
        for(i = a.length - 1; i >= 1; i--){
            if(a[i] > a[i - 1])
                break;
        }
        if(i <= 0)
            return false;
        for(j = a.length - 1; j >= i && i > 0; j--){
            if(a[j] > a[i - 1])
                break;
        }
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static int calculate(int a[]) {
        int sum = 0;
        for (int i=1; i<a.length; i++) {
            sum += Math.abs(a[i] - a[i-1]);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line[i]);
        Arrays.sort(a);
        int ans = Integer.MIN_VALUE;
        int k = 1;
        do{
            int temp = calculate(a);
            ans = Math.max(temp, ans);
            k++;
        }while(next(a, k));

        System.out.println(ans);
    }
}
