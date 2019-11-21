import java.util.*;
import java.io.*;
public class Main {
    static int ans = 0;

    public static void count(String s1, String s2){
        if(s1.length() < s2.length())
            return;
        if(s1.startsWith(s2)){
            ans++;
            int len2 = s2.length();
            int len1 = s1.length();
            s1 = s1.substring(len2, len1);
            count(s1, s2);
        }
        else{
            int len = s1.length();
            s1 = s1.substring(1, len);
            count(s1, s2);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();
        count(line1, line2);
        System.out.println(ans);
    }
}
