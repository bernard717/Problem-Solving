import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        int cnt = input.nextInt();
        int[] a = new int[cnt + 1];
        int[] d = new int[cnt + 1];
        for(int i = 1; i < cnt + 1; i++)
            a[i] = input.nextInt();

        for(int i = 1; i <= cnt; i++){
            for(int j = 1; j <= i; j++) {
                int temp = a[j] + d[i - j];
                d[i] = Math.max(d[i], temp);
            }
        }

        System.out.println(d[cnt]);

    }
}
