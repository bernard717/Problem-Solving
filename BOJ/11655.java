import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String ans = "";
        for(int i = 0; i < line.length(); i++){
            char temp = line.charAt(i);
            if(temp >= 'a' && temp <= 'm')
                temp += 13;
            else if(temp >= 'A' && temp <= 'M')
                temp += 13;
            else if(temp >= 'n' && temp <= 'z')
                temp -= 13;
            else if(temp >= 'N' && temp <= 'Z')
                temp -= 13;
            ans += temp;
        }
        System.out.println(ans);

    }
}
