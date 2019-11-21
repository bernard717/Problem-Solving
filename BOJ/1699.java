import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] d = new int[num + 1];

        for(int i = 1; i <= num; i++){
            d[i] = i;
            for(int j = 1; j * j <= i; j++)
                d[i] = Math.min(d[i - j * j] + 1, d[i]);
        }

        System.out.println(d[num]);

    }
}
