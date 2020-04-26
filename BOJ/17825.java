import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static ArrayList<Integer>[] adj;
    static int[] dice, pos = {0, 0, 0, 0};
    static boolean[] horseBlue;
    static boolean[][] horseExist;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        dice = new int[10];
        for(int i = 0; i < 10; i++)
            dice[i] = Integer.parseInt(line[i]);

        adj = new ArrayList[41];
        for(int i = 0; i < 41; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < 41; i += 2)
            adj[i].add(i + 2);

        adj[10].add(13);
        adj[13].add(16);
        adj[16].add(19);
        adj[19].add(25);
        adj[20].add(22);
        adj[22].add(24);
        adj[24].add(25);
        adj[30].add(28);
        adj[28].add(27);
        adj[27].add(26);
        adj[26].add(25);
        adj[25].add(30);
        adj[30].add(35);
        adj[35].add(40);

        // 각 지점에 말이 있는지 없는지
        horseExist = new boolean[43][2];
        horseExist[0][0] = true;

        // 각 말이 파란 경로에 있는지 없는지
        horseBlue = new boolean[4];

        dfs(0, 0);

        System.out.print(ans);
    }
    static void dfs(int turn, int score){
        if(turn == 10){
            if(score > ans)
                ans = score;
            return;
        }
        // 0번 말부터 3번말까지 이동해 봄
        for(int i = 0; i < 4; i++){
            // 현재 말이 도착 지점에 있는 경우
            if(pos[i] > 40) continue;
            // 현재 위치
            int now = pos[i];
            // 다음 위치
            int next = 0;
            // 이번 턴의 주사위 칸 수
            int time = dice[turn];
            // 이번 말이 파란색 경로에 이미 들어가 있는 경우
            if(horseBlue[i]) {
                int temp = now;
                for(int j = 0; j < time; j++){
                    next = adj[temp].get(adj[temp].size() - 1);
                    temp = next;
                    if(temp > 40)
                        break;
                }
                if(next < 40 && horseExist[next][1]) continue;
                if(next == 40 && (horseExist[next][0] || horseExist[next][1])) continue;
                int plus = next;
                if(next > 40) {
                    next = 42;
                    plus = 0;
                }
                horseExist[now][1] = false;
                horseExist[next][1] = true;
                pos[i] = next;
                dfs(turn + 1, score + plus);
                horseExist[now][1] = true;
                horseExist[next][1] = false;
                pos[i] = now;
            }
            // 파란색 경로에 아직 들어가지 않은 경우
            else {
                // 10, 20, 30인 경우
                if(now == 10 || now == 20 || now == 30){
                    int sum = 0;
                    if(now == 30)
                        sum++;
                    next = adj[now].get(1);
                    int temp = next;
                    for(int j = 0; j < time - 1; j++){
                        next = adj[temp].get(adj[temp].size() - 1);
                        temp = next;
                        if(temp > 40)
                            break;
                    }
                    if(next <= 40 && horseExist[next][1]) continue;
                    if(next == 40 && (horseExist[next][0] || horseExist[next][1])) continue;
                    int plus = next;
                    if(next > 40) {
                        next = 42;
                        plus = 0;
                    }
                    horseBlue[i] = true;
                    horseExist[now][0] = false;
                    horseExist[next][1] = true;
                    pos[i] = next;
                    dfs(turn + 1, score + plus);
                    horseBlue[i] = false;
                    horseExist[now][0] = true;
                    horseExist[next][1] = false;
                    pos[i] = now;
                }
                // 나머지 경우
                else {
                    int temp = now;
                    for(int j = 0; j < time; j++){
                        next = adj[temp].get(0);
                        temp = next;
                        if(temp > 40)
                            break;
                    }
                    if(next <= 40 && horseExist[next][0]) continue;
                    if(next == 40 && (horseExist[next][0] || horseExist[next][1])) continue;
                    int plus = next;
                    if(next > 40) {
                        next = 42;
                        plus = 0;
                    }
                    horseExist[now][0] = false;
                    horseExist[next][0] = true;
                    pos[i] = next;
                    dfs(turn + 1, score + plus);
                    horseExist[now][0] = true;
                    horseExist[next][0] = false;
                    pos[i] = now;
                }
            }
        }
    }
}
