import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String N = line[0];
        int B = Integer.parseInt(line[1]);
        int ans = 0;
        for(int i = 0; i < line[0].length(); i++){
            char a = line[0].charAt(i);
            if(a >= '0' && a <= '9')
                ans = ans * B + (a - '0');
            else
                ans = ans * B + (a -'A' + 10);
        }

        System.out.println(ans);
    }
}
