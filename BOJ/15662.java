import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static int n;
    static char[][] wheels;
    static int[] start;
    static ArrayList<Integer> clock;
    static ArrayList<Integer> counterclock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wheels = new char[n][2400];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < 300; j++){
                for(int k = 0; k < 8; k++)
                    wheels[i][8 * j + k] = line.charAt(k);
            }
        }
        // 각 wheel의 12시 방향 지점의 index값
        start = new int[n];
        for(int i = 0; i < n; i++)
            start[i] = 1200;

        // 회전 횟수
        int turn = Integer.parseInt(br.readLine());

        for(int i = 0; i < turn; i++){
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]) - 1;
            int dir = Integer.parseInt(line[1]);
            // 회전 적용 대상들을 arrayList에 집어 넣기
            clock = new ArrayList<>();
            counterclock = new ArrayList<>();
            turn(num, dir, true);
            turn(num, dir, false);
            for(int idx : clock)
                start[idx]--;
            for(int idx : counterclock)
                start[idx]++;
            if(dir == 1)
                start[num]++;
            else
                start[num]--;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(wheels[i][start[i]] == '1')
                ans++;
        }
        System.out.print(ans);
    }
    static void turn(int idx, int dir, boolean right){
        // 오른쪽 방향으로 진행
        if(right){
            // 오른쪽 시계와 극이 다른 경우
            if(idx + 1 < n && wheels[idx][start[idx] + 2] != wheels[idx + 1][start[idx + 1] + 6])
                turn(idx + 1, -1 * dir, right);
        }
        // 왼쪽 방향으로 진행
        else{
            // 왼쪽 시계와 극이 다른 경우
            if(idx - 1 >= 0 && wheels[idx][start[idx] + 6] != wheels[idx - 1][start[idx - 1] + 2])
                turn(idx - 1, -1 * dir, right);
        }
        // 시계 방향으로 회전
        if(dir == 1)
            clock.add(idx);
        // 반시계 방향으로 회전
        else
            counterclock.add(idx);
    }
}
