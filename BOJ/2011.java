import java.io.*;
import java.util.*;

public class Main {
    public static long mod = 1000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        long[] d = new long[line.length() + 1];
        int len = line.length();

        d[0] = 1;
        for(int i = 1; i <= line.length(); i++){
            int first = line.charAt(i-1) - '0';

            if(first != 0)
                d[i] = d[i-1] % mod;
            if(i == 1)
                continue;
            int second = Integer.parseInt(line.substring(i-2, i));
            if(second >= 10 && second <= 26)
                d[i] += d[i-2] % mod;
        }


        System.out.println(d[len] % mod);
    }
}
