import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;
        a = n / 300;
        n %= 300;
        b = n / 60;
        n %= 60;
        c = n / 10;
        if(n % 10 != 0)
            System.out.println(-1);
        else
            System.out.print(a + " " + b + " " + c + "\n");
    }
}
