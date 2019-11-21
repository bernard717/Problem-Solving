import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            String line = input.nextLine();
            int[] array = new int[4];
            for(int i = 0; i < line.length(); i++){
                char temp = line.charAt(i);
                if(temp >= 'a' && temp <= 'z')
                    array[0]++;
                else if(temp >= 'A' && temp <= 'Z')
                    array[1]++;
                else if(temp >= '0' && temp <= '9')
                    array[2]++;
                else
                    array[3]++;
            }
            for(int i = 0; i < 3; i++)
                System.out.print(array[i] + " ");
            System.out.println(array[3]);
        }
    }
}
