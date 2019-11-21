import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int sum = 0;
        int leftN = 0;
        int leftM = 0;
        if(n > 2 * m){
            sum += m;
            leftN = n - 2 * m;
        }
        else if(n < 2 * m){
            sum += n / 2;
            leftM = m - n / 2;
            leftN = n % 2 == 0 ? 0 : 1;
        }
        else
            sum += n / 2;
        if(k > leftM + leftN){
            k -= leftM + leftN;
            while(k > 0){
                sum--;
                k -= 3;
            }
        }
        System.out.println(sum);
    }
}
