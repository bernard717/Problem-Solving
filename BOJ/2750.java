import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<Integer>();
        String first = bf.readLine();
        int num = Integer.valueOf(first);
        while(num-- > 0){
            int what = Integer.parseInt(bf.readLine());
            a.add(what);
        }
        Collections.sort(a);
        for(int x: a){
            System.out.println(x);
        }
    }
}
