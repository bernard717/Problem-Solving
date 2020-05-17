import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        ArrayList<Character> kinds = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        char st = s.charAt(0);
        int cnt = 1;
        kinds.add(st);
        for(int i = 1; i < n; i++){
            char c = s.charAt(i);
            if(st == c){
                cnt++;
            }
            else{
                nums.add(cnt);
                kinds.add(c);
                st = c;
                cnt = 1;
            }
        }
        nums.add(cnt);

        long ans = 0;

        for(int i = 0; i < kinds.size(); i++){
            ans += nums.get(i) * (nums.get(i) + 1) / 2;
            if(nums.get(i) == 1){
                if(i >= 1 && (i + 1) < kinds.size() && kinds.get(i - 1) == kinds.get(i + 1)){
                    ans += Math.min(nums.get(i - 1), nums.get(i + 1));
                }
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
