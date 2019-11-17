import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] array = new int[10];
        for(int i = 0; i < num.length(); i++)
            array[num.charAt(i) - '0']++;
        int ans1 = (array[6] + array[9] + 1) / 2;
        int ans2 = 0;
        for(int i = 0; i < 9; i++){
            if(i != 6) {
                if (ans2 < array[i])
                    ans2 = array[i];
            }
        }
        int ans = Math.max(ans1, ans2);
        System.out.println(ans);
    }
}
