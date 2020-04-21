import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
            int temp = Integer.parseInt(line[0]);
            if(temp <= 1) continue;
            for(int j = 1; j < temp; j++){
                int shorter = Integer.parseInt(line[j]);
                int taller = Integer.parseInt(line[j + 1]);
                indegree[taller]++;
                arr[shorter].add(taller);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        // 정답 저장하는 arrayList
        ArrayList<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int temp = queue.remove();
            ans.add(temp);
            for(int now : arr[temp]){
                indegree[now]--;
                if(indegree[now] == 0)
                    queue.add(now);
            }
        }
        if(ans.size() != n) {
            System.out.print(0);
            return;
        }
        for(int i = 0; i < n; i++)
            System.out.println(ans.get(i));
    }
}
