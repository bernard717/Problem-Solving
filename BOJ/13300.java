import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] male = new int[7];
        int[] female = new int[7];
        for(int i = 0; i < n; i++){
            String[] student = br.readLine().split(" ");
            int gender = Integer.parseInt(student[0]);
            int grade = Integer.parseInt(student[1]);
            if(gender == 1)
                male[grade]++;
            else
                female[grade]++;
        }
        int ans = 0;
        for(int i = 1; i < 7; i++){
            ans += (int)Math.ceil((double)male[i] / (double)k);
            ans += (int)Math.ceil((double)female[i] / (double)k);
        }
        System.out.println(ans);
    }
}
