import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long[] d = new long[num + 1];
        d[0] = 1;
        for (int i=2; i<=num; i+=2) {
            d[i] = d[i-2]*3;
            for (int j=i-4; j>=0; j-=2) {
                d[i] += d[j]*2;
            }
        }

        System.out.println(d[num]);

    }
}
