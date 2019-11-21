import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int ans = 0;
        StringTokenizer st = new StringTokenizer(line);
        while(st.hasMoreTokens()){
            ans += Integer.valueOf(st.nextToken());
        }
        System.out.println(ans);
    }
}
