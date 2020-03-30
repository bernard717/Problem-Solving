import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        // 5개 이하를 가르치면 "anta", "tica"를 읽을 수 없음
        if(k < 5){
            System.out.print(0);
            return;
        }
        // "anta", "tica"를 읽기 위해 a, n, t, i, c는 무조건 배움
        String[] words = new String[n];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            words[i] = temp.substring(4, temp.length() - 4);
        }
        k -= 5;

        char[] alphabet = {'b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z'};
        int[] arr = new int[21];
        for(int i = 0; i < k; i++)
            arr[20 - i] = 1;
        boolean[] learned = new boolean[26];
        learned['a' - 'a'] = true;
        learned['c' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;

        int answer = Integer.MIN_VALUE;

        do{
            int[] temp = new int[k];
            int idx = 0;
            for(int i = 0; i < 21; i++){
                if(arr[i] == 1) {
                    learned[alphabet[i] - 'a'] = true;
                    temp[idx++] = alphabet[i] - 'a';
                }
            }
            int sum = 0;
            for(String word : words){
                boolean flag = true;
                for(int i = 0; i < word.length(); i++){
                    if(!learned[word.charAt(i) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    sum++;
            }
            for(int i : temp)
                learned[i] = false;
            answer = Math.max(sum, answer);
        }while(next(arr));
        System.out.print(answer);
    }
    static boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(i < j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
            i++;
        }
        return true;
    }
}
