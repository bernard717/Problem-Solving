import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        System.out.println(func(a, b, c));
    }
    public static long func(int a, int b, int c){
        if(b == 0) return 1;
        long val = func(a, b/2, c);
        val = val * val % c;
        if(b%2 == 0) return val;
        return val * a % c;
    }
}
