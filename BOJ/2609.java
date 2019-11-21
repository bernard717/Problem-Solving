import java.io.*;
import java.util.*;

public class Main {
    public static int GCD(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        System.out.println(GCD(a, b));
        System.out.println(a * b / GCD(a, b));

    }
}
