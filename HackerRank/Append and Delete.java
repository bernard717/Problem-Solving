import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int i = 0;
        int sLen = s.length(), tLen = t.length();
        for(i = 0; i < sLen && i < tLen; i++){
            if(s.charAt(i) != t.charAt(i))
                break;
        }
        if(sLen + tLen - 2 * i > k)
            return "No";
        if((sLen + tLen - 2 * i) % 2 == k % 2)
            return "Yes";
        if(sLen + tLen <= k)
            return "Yes";
        return "No";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
