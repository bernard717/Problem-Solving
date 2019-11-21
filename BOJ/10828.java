import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<Integer>();
        int num = Integer.valueOf(bf.readLine());
        while(num > 0){
            String[] line = bf.readLine().split(" ");
            if(line[0].equals("push")){
                st.push(Integer.valueOf(line[1]));
            }
            else if(line[0].equals("top")){
                if(st.empty()){
                    System.out.println(-1);
                }
                else
                    System.out.println(st.peek());
            }
            else if(line[0].equals("size")){
                System.out.println(st.size());
            }
            else if(line[0].equals("pop")){
                if(st.empty()){
                    System.out.println(-1);
                }
                else
                    System.out.println(st.pop());
            }
            else if(line[0].equals("empty")){
                if(st.empty()){
                    System.out.println(1);
                }
                else
                    System.out.println(0);
            }




            num--;
        }
    }
}
