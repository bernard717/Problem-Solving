import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] symbols = new char[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            symbols[i] = s[i].charAt(0);

        int[] perm = new int[10];

        for(int i = 0; i <= n; i++)
            perm[9 - i] = 1;

        String min = "999";
        String max = "000";

        do{
            int[] arr = new int[n + 1];
            int idx = 0;
            for(int i = 0; i < 10; i++){
                if(perm[i] == 1)
                    arr[idx++] = i;
            }
            do{
                if(check(arr, symbols)){
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i <= n; i++)
                        sb.append(arr[i]);
                    String temp = sb.toString();
                    if(temp.compareTo(min) < 0) min = temp;
                    if(temp.compareTo(max) > 0) max = temp;
                }
            }while(next(arr));
        }while(next(perm));

        System.out.println(max);
        System.out.println(min);
    }
    public static boolean next(int[] a){
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
        while(j > i){
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            j--;
            i++;
        }
        return true;
    }
    public static boolean check(int[] arr, char[] symbols){
        for(int i = 0; i < arr.length - 1; i++){
            int front = arr[i];
            int back = arr[i + 1];
            char symbol = symbols[i];
            if(symbol == '<' && front > back)
                return false;
            if(symbol == '>' && front < back)
                return false;
        }
        return true;
    }
}
