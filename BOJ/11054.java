import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num + 1];
        String[] line = br.readLine().split(" ");
        for(int i = 1; i <= num; i++)
            array[i] = Integer.parseInt(line[i-1]);
        int[] d = new int[num + 1];
        int[] d2 = new int[num + 1];
        d[1] = 1;
        d2[1] = 1;
        int max = 0;

        for(int i = 2; i <= num; i++){
            for(int j = 1; j < i; j++){
                if(array[j] < array[i])
                    max = Math.max(d[j], max);
            }
            d[i] = max + 1;
            max = 0;
        }

        for(int i = num; i >= 1; i--){
            for(int j = i+1; j <= num; j++){
                if(array[j] < array[i])
                    max = Math.max(d2[j], max);
            }
            d2[i] = max + 1;
            max = 0;
        }


        int ans = 1;
        for(int i = 1; i <= num; i++)
            ans = Math.max(ans, d[i] + d2[i] - 1);
        System.out.println(ans);

    }
}
