import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 0;
        while(num-- > 0){
            i++;
            String[] a= br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(i);
            sb.append(": ");
            sb.append(a[0]);
            sb.append(" + ");
            sb.append(a[1]);
            sb.append(" = ");
            sb.append(Integer.parseInt(a[0]) + Integer.parseInt(a[1]));
            System.out.println(sb);
        }

    }
}
