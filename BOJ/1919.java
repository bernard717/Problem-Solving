import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < line1.length(); i++)
            a[line1.charAt(i) - 'a']++;
        for(int i = 0; i < line2.length(); i++)
            b[line2.charAt(i) - 'a']++;
        int sum = 0;
        for(int i = 0; i < 26; i++)
            sum += Math.abs(a[i] - b[i]);
        System.out.println(sum);
    }
}
