import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[4000001];
        arr[0] = true;
        arr[1] = true;

        // 소수면 false, 소수가 아니면 true
        for(int i = 2; i * i <= 4000000; i++){
            if(arr[i]) continue;
            for(int j = i + i; j <= 4000000; j+=i)
                arr[j] = true;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 2; i <= 4000000; i++){
            if(!arr[i])
                arrayList.add(i);
        }
        int answer = 0;
        for(int i = 0; i < arrayList.size(); i++){
            int sum = 0;
            for(int j = i; j < arrayList.size(); j++){
                sum += arrayList.get(j);
                if(sum == n) {
                    answer++;
                    break;
                }
                else if(sum > n)
                    break;
            }
        }
        System.out.print(answer);
    }
}
