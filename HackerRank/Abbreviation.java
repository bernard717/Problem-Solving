import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static boolean[][] d;
    static boolean[][] visited;

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        d = new boolean[lenA + 1][lenB + 1];
        visited = new boolean[lenA + 1][lenB + 1];

        if(recur(a, b, lenA, lenB))
            return "YES";
        else
            return "NO";
    }

    public static boolean recur(String a, String b, int lenA, int lenB){
        if(visited[lenA][lenB])
            return d[lenA][lenB];
        if(a.length() == 0 && b.length() == 0){
            visited[lenA][lenB] = true;
            d[lenA][lenB] = true;
            return true;
        }
        if(a.length() == 0){
            visited[lenA][lenB] = true;
            d[lenA][lenB] = false;
            return false;
        }
        if(b.length() == 0){
            for(char c : a.toCharArray()){
                if(!isLowerCase(c)){
                    visited[lenA][lenB] = true;
                    d[lenA][lenB] = false;
                    return false;
                }
            }
            visited[lenA][lenB] = true;
            d[lenA][lenB] = true;
            return true;
        }
        // 끝자리 두 개
        char endA = a.charAt(a.length() - 1);
        char endB = b.charAt(b.length() - 1);
        // 끝자리를 지운 문자열
        String tempA = a.substring(0, a.length() - 1);
        String tempB = b.substring(0, b.length() - 1);
        // a의 끝자리가 대문자인데 b의 끝자리와 같지 않은 경우
        if(!isLowerCase(endA) && endA != endB){
            visited[lenA][lenB] = true;
            d[lenA][lenB] = false;
            return false;
        }
        // 끝자리가 둘 다 대문자로 같은 경우
        if(endA == endB){
            visited[lenA][lenB] = true;
            d[lenA][lenB] = recur(tempA, tempB, lenA - 1, lenB - 1);
            return recur(tempA, tempB, lenA - 1, lenB - 1);
        }
        // a의 끝자리가 소문자이고 b의 끝자리와 같지 않은 경우
        if(endA != Character.toLowerCase(endB)){
            visited[lenA][lenB] = true;
            d[lenA][lenB] = recur(tempA, b, lenA - 1, lenB);
            return recur(tempA, b, lenA - 1, lenB);
        }
        visited[lenA][lenB] = true;
        d[lenA][lenB] = recur(tempA, b, lenA - 1, lenB) || recur(tempA, tempB, lenA - 1, lenB - 1);
        return recur(tempA, b, lenA - 1, lenB) || recur(tempA, tempB, lenA - 1, lenB - 1);
    }

    public static boolean isLowerCase(char c){
        return c >= 'a' && c <= 'z';
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
