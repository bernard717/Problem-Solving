import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> st = new Stack<Character>();
        int cntStick = 0;
        int cntCut = 0;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '('){
                st.push('(');
            }
            else{
                if(line.charAt(i - 1) == '('){
                    st.pop();
                    cntCut += st.size();
                }
                else{
                    st.pop();
                    cntStick++;
                }
            }
        }
        System.out.println(cntCut + cntStick);
    }
}
