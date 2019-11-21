import java.util.*;
import java.io.*;
public class Main {
    static int[] a;
    static int[] howMany;
    static int n;
    public static boolean next(int[] a){
        int i = a.length - 1;
        while(i >= 1 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(j >= i && a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(j > i){
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            j--;
            i++;
        }
        return true;
    }
    public static int calc(int x, int y, int symbol){
        if(symbol == 1)
            return x + y;
        else if(symbol == 2)
            return x - y;
        else if(symbol == 3)
            return x * y;
        else{
            if(x < 0)
                return ((-1) * x / y) * (-1);
            else
                return x / y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        howMany = new int[4];
        String[] line1 = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line1[i]);
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < 4; i++)
            howMany[i] = Integer.parseInt(line2[i]);
        int[] per = new int[n - 1];
        for(int i = 0; i < howMany[0]; i++)
            per[i] = 1;
        for(int i = 0; i < howMany[1]; i++)
            per[i + howMany[0]] = 2;
        for(int i = 0; i < howMany[2]; i++)
            per[i + howMany[0] + howMany[1]] = 3;
        for(int i = 0; i < howMany[3]; i++)
            per[howMany[0] + howMany[1] + howMany[2]] = 4;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        do{
            int sum = calc(a[0], a[1], per[0]);
            for(int i = 1; i < n - 1; i++)
                sum = calc(sum, a[i + 1], per[i]);
            max = Math.max(sum, max);
            min = Math.min(sum, min);
        }while(next(per));
        System.out.println(max);
        System.out.println(min);
    }
}
