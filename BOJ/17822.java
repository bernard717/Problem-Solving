import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{
    static class Pair{
        int circle, idx;
        public Pair(int circle, int idx){
            this.circle = circle;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int T = Integer.parseInt(line[2]);

        int[][] number = new int[N + 1][M];

        for(int i = 1; i <= N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < M; j++)
                number[i][j] = Integer.parseInt(line[j]);
        }

        int[] idx = new int[M * 50];
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < M; j++)
                idx[i * M + j] = j;
        }

        // 각 원판마다 시작지점의 idx를 유지하는 배열
        int[] start = new int[N + 1];
        for(int i = 0; i <= N; i++)
            start[i] = 25 * M;

        for(int i = 0; i < T; i++){
            line = br.readLine().split(" ");
            int which = Integer.parseInt(line[0]);
            int dir = Integer.parseInt(line[1]);
            int howmuch = Integer.parseInt(line[2]);

            // X의 배수의 번호인 원판들은 회전
            for(int j = 1; j <= N; j++){
                if(j % which == 0) {
                    // 반시계방향
                    if (dir == 0)
                        start[j] -= howmuch;
                    else
                        start[j] += howmuch;
                }
            }
            // 인접한 수들을 유지하는 HashSet
            HashSet<Pair> hashSet = new HashSet<>();

            // 같은 원판 내에서 같은 숫자 찾기
            for(int j = 1; j <= N; j++){
                for(int k = 0; k < M; k++){
                    if(number[j][idx[start[j] + k]] == 0) continue;
                    if(number[j][idx[start[j] + k]] == number[j][idx[start[j] + k + 1]]) {
                        hashSet.add(new Pair(j, idx[start[j] + k]));
                        hashSet.add(new Pair(j, idx[start[j] + k + 1]));
                    }
                }
            }
            // 인접한 원판에서 같은 숫자 찾기
            for(int j = 1; j < N; j++){
                for(int k = 0; k < M; k++) {
                    if(number[j][idx[start[j] + k]] == 0) continue;
                    if (number[j][idx[start[j] + k]] == number[j + 1][idx[start[j + 1] + k]]){
                        hashSet.add(new Pair(j, idx[start[j] + k]));
                        hashSet.add(new Pair(j + 1, idx[start[j + 1] + k]));
                    }
                }
            }
            // 인접해서 같은 수가 없는 경우
            if(hashSet.size() == 0){
                int sum = 0;
                int num = 0;
                for(int j = 1; j <= N; j++){
                    for(int k = 0; k < M; k++) {
                        if(number[j][k] == 0) continue;
                        sum += number[j][k];
                        num++;
                    }
                }
                double avg = (double)sum / (double)num;
                for(int j = 1; j <= N; j++){
                    for(int k = 0; k < M; k++) {
                        if(number[j][k] == 0) continue;
                        if(avg > number[j][k])
                            number[j][k]++;
                        else if(avg < number[j][k])
                            number[j][k]--;
                    }
                }
            }
            // 같은 수가 있는 경우
            else{
                for(Pair p : hashSet)
                    number[p.circle][p.idx] = 0;
            }
        }
        int ans = 0;
        for(int j = 1; j <= N; j++){
            for(int k = 0; k < M; k++) {
                ans += number[j][k];
            }
        }
        System.out.print(ans);
    }
}
