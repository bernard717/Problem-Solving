import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int[] num = new int[101];
        int len = s.length();
        if(s.charAt(0) == 'a') num[0] = 1;
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == 'a')
                num[i] = num[i - 1] + 1;
            else
                num[i] = num[i - 1];
        }
        long res = (n / len) * num[len - 1];
        System.out.print(num[0]);
        if((n % len) == 0)
            return res;
        res += num[(int)(n % len) - 1];
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
