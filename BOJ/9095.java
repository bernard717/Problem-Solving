import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        int cnt = input.nextInt();
        int[] d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i <= 11; i++){
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        while(cnt-- > 0){
            int num = input.nextInt();
            System.out.println(d[num]);
        }


    }
}
