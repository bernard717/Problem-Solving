import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num + 1];
        for(int i = 1; i <= num; i++)
            array[i] = Integer.parseInt(br.readLine());

        int[][] d = new int[num + 1][3];
        d[1][1] = array[1];

        for(int i = 2; i <= num; i++){
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + array[i];
            d[i][2] = d[i-1][1] + array[i];
        }

        int ans = Math.max(d[num][1], d[num][2]);

        System.out.println(ans);

    }
}
