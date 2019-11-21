import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int len = a.length();
        int j = 0;
        int fixedlen = len;
        while(len > 0){
            for(int i = j; i < j + 10 && i + 1 <= fixedlen; i++)
                sb.append(a.substring(i, i + 1));

            sb.append("\n");
            j += 10;
            len -= 10;
        }
        System.out.println(sb);
    }
}
