import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> a = new LinkedList<Integer>();
        String first = bf.readLine();
        int num = Integer.valueOf(first);
        while(num-- > 0){
            String[] line = bf.readLine().split(" ");
            if(line[0].equals("push"))
                a.offer(Integer.parseInt(line[1]));
            else if(line[0].equals("front")) {
                if (a.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(a.peek());
            }
            else if(line[0].equals("back")){
                if (a.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(((LinkedList<Integer>) a).getLast());
            }
            else if(line[0].equals("pop")){
                if (a.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(a.poll());
            }
            else if(line[0].equals("size"))
                System.out.println(a.size());
            else if(line[0].equals("empty")){
                int ans = a.isEmpty() ? 1 : 0;
                System.out.println(ans);
            }
        }
    }
}
