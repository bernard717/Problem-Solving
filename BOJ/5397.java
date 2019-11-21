import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();
        while(test-- > 0){
            String line = br.readLine();
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == '<'){
                    if(!left.empty())
                        right.push(left.pop());
                }
                else if(line.charAt(i) == '>'){
                    if(!right.empty())
                        left.push(right.pop());
                }
                else if(line.charAt(i) == '-'){
                    if(!left.empty())
                        left.pop();
                }
                else
                    left.push(line.charAt(i));
            }
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while(!right.empty())
                sb1.append(right.pop());
            while(!left.empty())
                sb2.append(left.pop());
            sb2 = sb2.reverse();
            System.out.println(sb2.append(sb1));
        }
    }
}
