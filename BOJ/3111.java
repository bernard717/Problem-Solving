import java.util.*;
import java.io.*;
public class Main {
    static char[] a, ar, b;
    static char[] l = new char[300001];
    static char[] r = new char[300001];
    static int ln = 0, rn = 0;
    static int n, m;
    static boolean check(int where){
        char[] stack = l;
        int len = ln;
        char[] str = ar;
        if(where == 1){
            stack = r;
            len = rn;
            str = a;
        }
        if(len - n < 0)
            return false;
        for(int i = 0; i < n; i++){
            if(stack[len - i - 1] != str[i])
                return false;
        }
        if(where == 0)
            ln -= n;
        else
            rn -= n;
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        n = a.length;
        ar = new char[n];
        for(int i = 0; i < n; i++)
            ar[i] = a[n - i - 1];
        b = br.readLine().toCharArray();
        m = b.length;
        int left = 0, right = m - 1, where = 0;
        while(left <= right){
            if(where == 0)
                l[ln++] = b[left++];
            else
                r[rn++] = b[right--];
            if(check(where))
                where = 1 - where;
        }
        for(int i = ln - 1; i >= 0; i--){
            r[rn++] = l[i];
            check(1);
        }
        for(int i = rn - 1; i >= 0; i--)
            System.out.print(r[i]);
        System.out.println();
    }
}
