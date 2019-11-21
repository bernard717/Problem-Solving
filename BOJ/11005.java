import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            if(N%B <= 9)
                sb.append((char)(N%B + '0'));
            else
                sb.append((char)(N%B -10 + 'A'));
            N /= B;
        }

        System.out.println(sb.reverse());
    }
}
