import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while(n / 5 != 0){
            ans += n / 5;
            n /= 5;
        }
        System.out.println(ans);
    }
}
