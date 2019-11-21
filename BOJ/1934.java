import java.io.*;
import java.util.*;

public class Main {
    public static long GCD(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            String[] line = br.readLine().split(" ");

            long a = Integer.parseInt(line[0]);
            long b = Integer.parseInt(line[1]);

            System.out.println(a * b / GCD(a, b));
        }
    }
}
