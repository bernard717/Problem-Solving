import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int n;
    public static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        int[] operators = new int[4];
        s = br.readLine().split(" ");

        for(int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(s[i]);
            operators[i] = temp;
        }

        solve(1, arr[0], operators[0], operators[1], operators[2], operators[3], arr);

        Collections.sort(answers);

        System.out.println(answers.get(answers.size() - 1));
        System.out.print(answers.get(0));
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
    public static void solve(int idx, int sum, int plus, int minus, int mult, int div, int[] arr){
        if(idx == n){
            answers.add(sum);
            return;
        }
        if(plus != 0)
            solve(idx + 1, calc(sum, arr[idx], 1), plus - 1, minus, mult, div, arr);
        if(minus != 0)
            solve(idx + 1, calc(sum, arr[idx], 2), plus, minus - 1, mult, div, arr);
        if(mult != 0)
            solve(idx + 1, calc(sum, arr[idx], 3), plus, minus, mult - 1, div, arr);
        if(div != 0)
            solve(idx + 1, calc(sum, arr[idx], 4), plus, minus, mult, div - 1, arr);
    }
}
