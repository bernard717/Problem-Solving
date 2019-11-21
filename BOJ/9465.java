import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testnum = Integer.parseInt(br.readLine());

        while(testnum-- > 0){
            int cnt = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][cnt + 1];
            int[][] d = new int[cnt + 1][3];
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            for(int i = 1; i <= cnt; i++)
                sticker[0][i] = Integer.parseInt(line1[i - 1]);
            for(int i = 1; i <= cnt; i++)
                sticker[1][i] = Integer.parseInt(line2[i - 1]);

            for(int i = 1; i <= cnt; i++){
                d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][2], d[i-1][1]));

                d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + sticker[0][i];

                d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + sticker[1][i];
            }
            int ans;
            ans = Math.max(d[cnt][0], Math.max(d[cnt][1], d[cnt][2]));
            System.out.println(ans);
        }

    }
}
