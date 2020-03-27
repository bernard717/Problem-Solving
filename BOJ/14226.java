import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class Pair{
        int x, clip;
        public Pair(int x, int clip){
            this.x = x;
            this.clip = clip;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] depth = new int[n * 2][n * 2];
        for(int i = 0; i < n * 2; i++){
            for(int j = 0; j < n * 2; j++)
                depth[i][j] = -1;
        }

        depth[1][1] = 0;
        depth[2][1] = 2;
        if(n == 2){
            System.out.print(2);
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(2, 1));

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int now = p.x;
            int clip = p.clip;
            // clip에 있는 걸 붙여넣기
            int nx = now + clip;
            if(nx >= 0 && nx < n * 2 && clip >= 0 && clip < n * 2 && depth[nx][clip] == -1){
                depth[nx][clip] = depth[now][clip] + 1;
                queue.add(new Pair(nx, clip));
            }
            // -1하기
            nx = now - 1;
            if(nx >= 0 && nx < n * 2 && clip >= 0 && clip < n * 2 && depth[nx][clip] == -1){
                depth[nx][clip] = depth[now][clip] + 1;
                queue.add(new Pair(nx, clip));
            }
            // 복사
            int nclip = now;
            nx = now;
            if(nx >= 0 && nx < n * 2 && nclip < n * 2 && depth[nx][nclip] == -1){
                depth[nx][nclip] = depth[now][clip] + 1;
                queue.add(new Pair(nx, nclip));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n * 2; i++){
            if(depth[n][i] == -1) continue;
            min = Math.min(depth[n][i], min);
        }
        System.out.print(min);
    }
}
