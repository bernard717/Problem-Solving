import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] wine = new int[num + 1];
        for(int i = 1; i <= num; i++)
            wine[i] = Integer.parseInt(br.readLine());
        long[] d = new long[num + 1];
        d[1] = wine[1];
        if(num >= 2)
            d[2] = wine[1] + wine[2];
        for(int i = 3; i <= num; i++){
            d[i] = Math.max(d[i-1], Math.max(d[i-2] + wine[i], d[i-3] + wine[i-1] + wine[i]));
        }
        System.out.println(d[num]);

    }
}
