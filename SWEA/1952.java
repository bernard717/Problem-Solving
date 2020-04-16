import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int min, oneDay, oneMonth, threeMonth, oneYear;
    static int[] using;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            String[] line = br.readLine().split(" ");
            oneDay = Integer.parseInt(line[0]);
            oneMonth = Integer.parseInt(line[1]);
            threeMonth = Integer.parseInt(line[2]);
            oneYear = Integer.parseInt(line[3]);

            line = br.readLine().split(" ");
            using = new int[12];
            for(int i = 0; i < 12; i++)
                using[i] = Integer.parseInt(line[i]);

            // 1년권 사용을 기본값으로 설정
            min = oneYear;

            dfs(0, 0);


            System.out.println("#" + T + " " + min);
        }
    }
    static void dfs(int month, int sum){
        if(month >= 12){
            min = Math.min(sum, min);
            return;
        }
        // 이번달에 수강하지 않으면 pass
        if(using[month] == 0)
            dfs(month + 1, sum);
        // 이번달에 수강하는 경우
        else{
            // 1일권 사용
            dfs(month + 1, sum + using[month] * oneDay);
            // 1달권 사용
            dfs(month + 1, sum + oneMonth);
            // 3달권 사용
            dfs(month + 3, sum + threeMonth);
        }
    }
}
