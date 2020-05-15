import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int ans = 0;
        for(int len = 1; len < s.length(); len++){
            for(int i = 0; i + len <= s.length(); i++){
                for(int j = i + 1; j + len <= s.length(); j++){
                    ans += isAnagrams(s.substring(i, i + len), s.substring(j, j + len));
                }
            }
        }
        return ans;
    }

    static int isAnagrams(String a, String b){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char now = a.charAt(i);
            Integer val = map.get(now);
            if(val == null)
                map.put(now, 1);
            else
                map.put(now, val + 1);
        }
        for(int i = 0; i < b.length(); i++){
            char now = b.charAt(i);
            Integer val = map.get(now);
            if(val == null)
                return 0;
            else{
                if(val > 1)
                    map.put(now, val - 1);
                else
                    map.remove(now);
            }
        }
        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
