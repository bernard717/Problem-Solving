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

        line = br.readLine().split(" ");
        int knowing = Integer.parseInt(line[0]);
        if(knowing == 0){
            System.out.print(m);
            return;
        }
        int[] knowingPerson = new int[knowing];
        for(int i = 0; i < knowing; i++)
            knowingPerson[i] = Integer.parseInt(line[i + 1]) - 1;

        // 파티 별로 참가하는 사람들
        ArrayList<Integer>[] peoplePerParty = new ArrayList[m];
        for(int i = 0; i < m; i++)
            peoplePerParty[i] = new ArrayList<>();

        // 사람들 별로 참가하는 파티
        ArrayList<Integer>[] partyPerPeople = new ArrayList[n];
        for(int i = 0; i < n; i++)
            partyPerPeople[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            line = br.readLine().split(" ");
            int temp = Integer.parseInt(line[0]);
            for(int j = 0; j < temp; j++){
                int who = Integer.parseInt(line[j + 1]) - 1;
                peoplePerParty[i].add(who);
                partyPerPeople[who].add(i);
            }
        }

        // 해당 파티가 진실만 가능한 상태인지 유지하는 배열
        boolean[] onlyTruth = new boolean[m];

        // queue에 들어간 적 있는지 확인하는 배열
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < knowing; i++) {
            int temp = knowingPerson[i];
            queue.add(temp);
            visited[temp] = true;
            for(int num : partyPerPeople[temp])
                onlyTruth[num] = true;
        }

        while(!queue.isEmpty()){
            // 현재 진실을 아는 사람
            int now = queue.remove();
            // 이 사람이 속한 파티
            for(int party : partyPerPeople[now]){
                // 해당 파티에 속한 사람들은 진실만 알아야 하니까 queue에 넣음
                for(int newPerson : peoplePerParty[party]){
                    if(visited[newPerson]) continue;
                    queue.add(newPerson);
                    visited[newPerson] = true;
                }
                onlyTruth[party] = true;
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            if(!onlyTruth[i])
                ans++;
        }
        System.out.print(ans);

    }
}
