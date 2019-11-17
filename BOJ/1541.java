import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] strArr1 = line.split("\\-");
        int sum = 0;
        for(int i = 0; i < strArr1.length; i++){
            String[] strArr2 = strArr1[i].split("\\+");
            int temp = 0;
            for(String x : strArr2)
                temp += Integer.parseInt(x);
            if(i == 0)
                temp *= -1;
            sum -= temp;
        }
        
        System.out.println(sum);
    }
}
