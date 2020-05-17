import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;

        int idx = 0;

        while(arr[idx] == 0)
            idx++;

        int one = arr[idx];
        int two = -1;
        int oneNum = 1, twoNum = 0;

        for(int i = idx + 1; i < 26; i++){
            if(arr[i] != 0){
                if(arr[i] != one && two != -1 && arr[i] != two)
                    return "NO";
                if(arr[i] == one)
                    oneNum++;
                else if(arr[i] == two)
                    twoNum++;
                else{
                    if(two == -1){
                        two = arr[i];
                        twoNum++;
                    }
                }
            }
        }
        if(two == -1)
            return "YES";
        if(oneNum >= twoNum && twoNum > 1)
            return "NO";
        if(twoNum >= oneNum && oneNum > 1)
            return "NO";
        if(one - two > 1 && twoNum > 1)
            return "NO";
        if(two - one > 1 && oneNum > 1)
            return "NO";
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
