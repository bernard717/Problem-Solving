import java.io.*;
import java.util.*;
public class Main{
    static boolean[] check = new boolean[10];
    public static int possible(int c){
        int ans = 0;
        int len = 0;
        if(c == 0)
            ans = check[c] ? 0 : 1;
        else{
            while(c > 0){
                if(check[c % 10])
                    return 0;
                len++;
                c /= 10;
            }
            ans += len;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int broken = Integer.parseInt(br.readLine());
        String[] line;
        if(broken != 0) {
            line = br.readLine().split(" ");
            for (int i = 0; i < broken; i++)
                check[Integer.parseInt(line[i])] = true;
        }
        int ans = Math.abs(n - 100);
        for(int i = 0; i < 1000000; i++){
            if(possible(i) != 0){
                ans = Math.min(ans, possible(i) + Math.abs(i - n));
            }
        }


        System.out.println(ans);
    }
}
