import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int five = 0;
        int three = 0;

        if(n == 7 || n == 4) {
            System.out.print(-1);
        }
        else{
            five = n / 5;
            int temp = n - 5 * five;
            while(temp % 3 != 0){
                five--;
                temp = n - 5 * five;
            }
            three = temp / 3;
            System.out.print(five + three);
        }
    }
}
