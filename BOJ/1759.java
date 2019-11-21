import java.io.*;
import java.util.*;

public class Main{
    public static boolean check(String password){
        int ja = 0, mo = 0;
        for(int i = 0; i < password.length(); i++){
            char what = password.charAt(i);
            if(what == 'a' || what == 'e' || what == 'i' || what == 'o' || what == 'u')
                mo++;
            else
                ja++;
        }
        return ja >= 2 && mo >= 1;
    }
    public static void go(int n, char[] alpha, String password, int i){
        if(password.length() == n){
            if(check(password))
                System.out.println(password);
            return;
        }
        if(i >= alpha.length)
            return;
        go(n, alpha, password + alpha[i], i + 1);
        go(n, alpha, password, i + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int l = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        String[] line2 = br.readLine().split(" ");
        char[] alpha = new char[line2.length];
        for(int i = 0; i < line2.length; i++)
            alpha[i] = line2[i].charAt(0);
        Arrays.sort(alpha);
        go(l, alpha, "", 0);
    }
}
