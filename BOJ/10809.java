import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String voca = br.readLine();
        int array[] = new int[26];
        for(int i = 0; i < 26; i++)
            array[i] = -1;
        for(int i = 0; i < voca.length(); i++){
            if(array[voca.charAt(i) - 'a'] == -1)
                array[voca.charAt(i) - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 25; i++)
            sb.append(array[i] + " ");
        sb.append(array[25]);



        System.out.println(sb);
    }
}
