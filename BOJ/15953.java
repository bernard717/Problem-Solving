import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        int[] prize1 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
        int[] prize2 = {5120000, 2560000, 1280000, 640000, 320000};

        int[] first = new int[100];
        int[] second = new int[64];

        int idx = 0;
        for(int i = 1; i <= 6; i++){
            for(int j = 0; j < i; j++)
                first[idx++] = prize1[i - 1];
        }
        idx = 0;
        for(int i = 1; i <= 5; i++){
            for(int j = 0; j < Math.pow(2, i - 1); j++)
                second[idx++] = prize2[i - 1];
        }

        for(int i = 0; i < test; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            if(a == -1)
                a = 99;
            if(b == -1)
                b = 63;
                
            System.out.println(first[a] + second[b]);
        }
    }
}
