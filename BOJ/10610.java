import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int tempSum = 0;
        boolean judge = true;
        for(int i = 0; i < line.length(); i++)
            tempSum += line.charAt(i) - '0';
        if(tempSum % 3 != 0)
            judge = false;
        if(!line.contains("0"))
            judge = false;
        char[] a = new char[line.length()];
        for(int i = 0; i < line.length(); i++)
            a[i] = line.charAt(i);
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        if(!judge)
            System.out.println(-1);
        else{
            for (int i = 0; i < line.length(); i++)
                sb.append(a[i]);
        }

        System.out.println(sb.reverse());
    }
}
