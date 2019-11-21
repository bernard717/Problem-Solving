import java.io.*;
import java.util.*;

public class Main {
    static class Compare implements Comparator<Integer>{
        public int compare (Integer one, Integer two){
            return two.compareTo(one);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Compare cmp = new Compare();
        int num = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1, cmp);
        while(num-- > 0){
            int temp = sc.nextInt();
            if(temp == 0){
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }
            else
                pq.offer(temp);
        }
    }
}
