import java.io.*;
import java.util.*;

public class Main {
    public static int two(int n){
        int ans = 0;
        while(n / 2 != 0){
            ans += n / 2;
            n /= 2;
        }
        return ans;
    }
    public static int five(int n){
        int ans = 0;
        while(n / 5 != 0){
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans1 = two(n) - two(m) - two((n-m));
        int ans2 = five(n) - five(m) - five((n-m));
        int ans = Math.min(ans1, ans2);
        System.out.println(ans);
    }
}
