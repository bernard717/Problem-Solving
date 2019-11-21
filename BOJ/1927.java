import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> a = new PriorityQueue<Integer>();
        String first = bf.readLine();
        int num = Integer.valueOf(first);
        while(num-- > 0){
            int what = Integer.parseInt(bf.readLine());
            if(what == 0){
                if(a.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(a.poll());
            }
            else
                a.offer(what);
        }
    }
}
