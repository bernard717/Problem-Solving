import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int len = line.length();
        for(int i = len - 1; i >= 0; i -= 3){
            int ans;
            if(i >= 2)
                ans = (line.charAt(i) - '0') + (line.charAt(i - 1) - '0') * 2 + (line.charAt(i - 2) -'0') * 4;
            else if(i == 1)
                ans = (line.charAt(i) - '0') + (line.charAt(i - 1) - '0') * 2;
            else
                ans = (line.charAt(i) - '0');
            sb.append(ans);
        }

        System.out.println(sb.reverse());
    }
}
