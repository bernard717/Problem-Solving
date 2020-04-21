import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        // indegree를 유지하는 배열
        int[] indegree = new int[n + 1];

        // 각 정점에서 다른 정점으로 향하는 간선을 유지하는 배열
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            line = br.readLine().split(" ");
            int shorter = Integer.parseInt(line[0]);
            int taller = Integer.parseInt(line[1]);
            indegree[taller]++;
            arr[shorter].add(taller);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        // 줄 세우기 완료된 학생 수
        int sum = 0;
        // 정답 저장하는 배열
        int[] ans = new int[n];
        while(sum < n){
            ans[sum] = queue.remove();
            for(int now : arr[ans[sum]]){
                indegree[now]--;
                if(indegree[now] == 0)
                    queue.add(now);
            }
            sum++;
        }
        for(int i = 0; i < n; i++)
            System.out.print(ans[i] + " ");
    }
}
