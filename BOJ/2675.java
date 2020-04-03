import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);

            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < s[1].length(); j++){
                for(int k = 0; k < num; k++)
                    sb.append(s[1].charAt(j));
            }
            System.out.println(sb.toString());
        }
    }
}
