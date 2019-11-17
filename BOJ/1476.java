import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int E = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int S = Integer.parseInt(line[2]);
        int e, m, s;
        e = m = s = 1;
        int i = 1;
        while(true){
            if(e == E && m == M && s == S){
                System.out.println(i);
                break;
            }
            e++;
            m++;
            s++;
            if(e == 16)
                e = 1;
            if(m == 29)
                m = 1;
            if(s == 20)
                s = 1;
            i++;
        }

    }
}
