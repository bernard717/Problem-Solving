import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        long[] d = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
        d = Arrays.copyOf(d, 101);
        for (int i = 10; i <= 100; i++) {
            d[i] = d[i - 5] + d[i - 1];
        }
        while(test-- > 0) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(d[num]);
        }
    }
}
