import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int ans = a * b * c;
        String line = Integer.toString(ans);
        int[] array = new int[10];
        for(int i = 0; i < line.length(); i++)
            array[line.charAt(i) - '0']++;
        for(int i = 0; i < 10; i++)
            System.out.println(array[i]);
    }
}
