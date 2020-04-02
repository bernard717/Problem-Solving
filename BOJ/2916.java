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
        int knowingNum = Integer.parseInt(line[0]);
        int askingNum = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        ArrayList<Integer> knowing = new ArrayList<>();
        for(int i = 0; i < knowingNum; i++)
            knowing.add(Integer.parseInt(line[i]));

        line = br.readLine().split(" ");
        int[] asking = new int[askingNum];
        for(int i = 0; i < askingNum; i++)
            asking[i] = Integer.parseInt(line[i]);

        boolean[] visited = new boolean[361];

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < knowingNum; i++) {
            queue.add(knowing.get(i));
            visited[knowing.get(i)] = true;
        }

        while(!queue.isEmpty()){
            int now = queue.remove();
            for(int i = 0; i < knowing.size(); i++){
                // 큐에 있는 각도끼리 더해서 새로운 각도 만듦
                int next = now + knowing.get(i);
                // 새로 만들어낸 각도가 0보다 작은 경우 
                if(next < 0)
                    next += 360;
                // 새로 만들어낸 각도가 360보다 큰 경우
                if(next > 360)
                    next -= 360;
                if(next >= 0 && next <= 360 && !visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    knowing.add(next);
                }
                // 큐에 있는 각도끼리 빼서 새로운 각도 만듦
                next = now - knowing.get(i);
                if(next >= 0 && next <= 360 && !visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    knowing.add(next);
                }
            }
        }
        for(int i = 0; i < askingNum; i++){
            if(visited[asking[i]])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
