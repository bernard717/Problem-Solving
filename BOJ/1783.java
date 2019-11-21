import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int ans;
        if(n == 1)
            ans = 1;
        else if(n == 2)
            ans = Math.min(4, (m+1) / 2);
        else {
            if(m < 7)
                ans = Math.min(4, m);
            else{
                ans = m - 2;
            }
        }

        System.out.println(ans);
    }
}
