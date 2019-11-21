import java.io.*;
import java.util.*;

public class Main {
    public static int GCD(int x, int y){
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x%y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            String[] line = br.readLine().split(" ");
            long sum = 0;
            for(int i = 1; i < line.length - 1; i++) {
                for(int j = i + 1; j < line.length; j++) {
                    sum += GCD(Integer.parseInt(line[i]), Integer.parseInt(line[j]));
                }
            }
            System.out.println(sum);
        }
    }
}
