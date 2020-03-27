import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] answer = {'E', 'A', 'B', 'C', 'D'};
        for(int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            int zero = 0;

            for(int j = 0; j < 4; j++){
                if(Integer.parseInt(s[j]) == 0)
                    zero++;
            }
            System.out.println(answer[zero]);
        }
    }
}
