import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int len = line.length();
        int start = 0;
        if(line.charAt(0) <= '3') {
            switch (line.charAt(0)) {
                case '0':
                    sb.append("0"); break;
                case '1':
                    sb.append("1"); break;
                case '2':
                    sb.append("10"); break;
                case '3':
                    sb.append("11");
            }
            start +=1;
        }
        StringBuilder temp1 = new StringBuilder();
        for(int i = start; i < len; i++){
            int temp = line.charAt(i) - '0';
            if(line.charAt(i) - '0' == 0)
                sb.append("000");
            if(line.charAt(i) - '0' == 1)
                sb.append("00");
            if(line.charAt(i) - '0' == 2 || line.charAt(i) - '0' == 3)
                sb.append("0");
            while(temp > 0){
                temp1.append(Integer.toString(temp % 2));
                temp /= 2;
            }
            sb.append(temp1.reverse());
            temp1.delete(0, temp1.length());
        }

        System.out.println(sb);
    }
}
