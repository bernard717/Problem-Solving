import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = func(n);

        System.out.print(answer);
    }
    public static int func(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return func(n - 1) + func(n - 2);
    }
}
