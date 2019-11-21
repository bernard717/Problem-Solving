import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line[] = bf.readLine().split(",");
        int ans = 0;
        int len = line.length;
        while(len > 0){
            ans += Integer.valueOf(line[line.length - len]);
            len--;
        }
        System.out.println(ans);
    }
}
