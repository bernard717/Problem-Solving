import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(s[i]);
            if(temp < x)
                System.out.print(temp + " ");
        }
    }
}
