import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = 0;
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            int num = 0;
            if(line.length > 1)
                num = Integer.parseInt(line[1]) - 1;
            if(line[0].equals("add"))
                s = s | (1 << num);
            else if(line[0].equals("remove"))
                s = s & ~(1 << num);
            else if(line[0].equals("check")){
                int res = s & (1 << num);
                if(res != 0)
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            else if(line[0].equals("toggle"))
                s = s ^ (1 << num);
            else if(line[0].equals("all"))
                s = (1 << 20) - 1;
            else if(line[0].equals("empty"))
                s = 0;
        }
        System.out.print(sb);
    }
}
