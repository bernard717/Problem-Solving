import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] freq;

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        // 각 비용별 빈도수를 저장하는 배열
        freq = new int[201];

        for(int i = 0; i < d; i++)
            freq[expenditure[i]]++;

        int st = 0;

        int ans = 0;

        for(int i = d; i < expenditure.length; i++){
            int now = expenditure[i];
            if(getMedian(d) <= now)
                ans++;
            freq[expenditure[st]]--;
            freq[expenditure[i]]++;
            st++;
        }
        return ans;
    }
    static int getMedian(int d){
        if(d % 2 == 0){
            int fir = d / 2;
            int sec = fir + 1;
            int sum = 0;
            int res = 0;
            for(int i = 0; i < 201; i++){
                sum += freq[i];
                if(sum >= fir){
                    res += i;
                    fir = Integer.MAX_VALUE;
                }
                if(sum >= sec)
                    return res + i;
            }
        }
        else{
            int fir = d / 2 + 1;
            int sum = 0;
            for(int i = 0; i < 201; i++){
                sum += freq[i];
                if(sum >= fir)
                    return i * 2;
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
