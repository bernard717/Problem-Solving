import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M, G, R;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        G = Integer.parseInt(line[2]);
        R = Integer.parseInt(line[3]);

        int[][] board = new int[N][M];

        // 배양액을 뿌릴 수 있는 곳의 좌표들
        ArrayList<Pair> possible = new ArrayList<>();

        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(line[j]);
                board[i][j] = temp;
                if(temp == 2)
                    possible.add(new Pair(i, j));
            }
        }

        // 배양액을 뿌릴 수 있는 곳의 수
        int len = possible.size();

        int[] perm = new int[len];
        for(int i = 0; i < R; i++)
            perm[i] = 3;
        for(int i = R; i < R + G; i++)
            perm[i] = 4;
        Arrays.sort(perm);

        int ans = -1;

        do{
            // 매 케이스마다 새로운 배열 가져옴
            int[][] garden = deepCopy(board);

            // 순열에 따라 배양액 뿌리는 위치 선정해서 뿌림
            for(int i = 0; i < len; i++){
                if(perm[i] == 3 || perm[i] == 4){
                    Pair p = possible.get(i);
                    garden[p.x][p.y] = perm[i];
                }
            }
            ans = Math.max(ans, test(garden));
        }while(next(perm));

        System.out.print(ans);
    }
    static boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i])
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
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            j--;
            i++;
        }
        return true;
    }
    static int test(int[][] garden){
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[][] distRed = new int[N][M];
        int[][] distGreen = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                distRed[i][j] = -1;
                distGreen[i][j] = -1;
                int temp = garden[i][j];
                if(temp == 3) {
                    queue.add(new Pair(i, j));
                    distRed[i][j] = 0;
                }
                else if(temp == 4) {
                    queue.add(new Pair(i, j));
                    distGreen[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            if(garden[p.x][p.y] == 5) continue;
            for(int k = 0; k < 4; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 새로운 위치에 아직 배양액이 없는 경우
                if(garden[nx][ny] == 1 || garden[nx][ny] == 2){
                    // 출발 위치가 빨간색인 경우
                    if(garden[p.x][p.y] == 3){
                        distRed[nx][ny] = distRed[p.x][p.y] + 1;
                        garden[nx][ny] = 3;
                        queue.add(new Pair(nx, ny));
                    }
                    // 출발 위치가 초록색인 경우
                    else{
                        distGreen[nx][ny] = distGreen[p.x][p.y] + 1;
                        garden[nx][ny] = 4;
                        queue.add(new Pair(nx, ny));
                    }
                }
                // 새로운 위치에 빨간색이 있는 경우
                else if(garden[nx][ny] == 3){
                    // 출발 위치가 초록색인 경우
                    if(garden[p.x][p.y] == 4){
                        distGreen[nx][ny] = distGreen[p.x][p.y] + 1;
                        // 초록색과 빨간색이 같은 시간에 도달한 경우
                        if(distGreen[nx][ny] == distRed[nx][ny]){
                            garden[nx][ny] = 5;
                            result++;
                        }
                        else
                            distGreen[nx][ny] = -1;
                    }
                }
                // 새로운 위치에 초록색이 있는 경우
                else if(garden[nx][ny] == 4){
                    // 출발 위치가 빨간색인 경우
                    if(garden[p.x][p.y] == 3){
                        distRed[nx][ny] = distRed[p.x][p.y] + 1;
                        // 초록색과 빨간색이 같은 시간에 도달한 경우
                        if(distGreen[nx][ny] == distRed[nx][ny]){
                            garden[nx][ny] = 5;
                            result++;
                        }
                        else
                            distRed[nx][ny] = -1;
                    }
                }
            }
        }
        return result;
    }
    static int[][] deepCopy(int[][] original2) {
        if(original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];

        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }
}
