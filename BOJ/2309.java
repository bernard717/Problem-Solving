import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        for(int i = 0; i < 9; i++)
            heights[i] = Integer.parseInt(br.readLine());

        int[] perm = {0, 0, 1, 1, 1, 1, 1, 1, 1};

        int[] answer = new int[7];

        do{
            int sum = 0;
            for(int i = 0; i < 9; i++){
                if(perm[i] == 1)
                    sum += heights[i];
            }
            if(sum == 100){
                int idx = 0;
                for(int i = 0; i < 9; i++){
                    if(perm[i] == 1)
                        answer[idx++] = heights[i];
                }
                Arrays.sort(answer);
                for(int i = 0; i < 7; i++)
                    System.out.println(answer[i]);
                return;
            }

        }while(next(perm));

    }
    public static boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(j > i){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
            i++;
        }
        return true;
    }
}
