import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static class Person{
        int x, y;
        public Person(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Stair{
        int x, y, len;
        public Stair(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            int ans = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];

            int peopleNum = 0;
            ArrayList<Person> people = new ArrayList<>();
            ArrayList<Stair> stairs = new ArrayList<>();

            for(int i = 0; i < N; i++){
                String[] line = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    int temp = Integer.parseInt(line[j]);
                    if(temp == 1) {
                        people.add(new Person(i, j));
                        peopleNum++;
                    }
                    else if(temp > 1)
                        stairs.add(new Stair(i, j, temp));
                }
            }
            // 모든 경우의 수 확인
            for(int i = 0; i < Math.pow(2, peopleNum); i++){
                ArrayList<Person> stair1 = new ArrayList<>();
                ArrayList<Person> stair2 = new ArrayList<>();
                for(int j = 0; j < peopleNum; j++){
                    // j번째 bit가 1인 경우
                    if((i & (1 << j)) == (1 << j))
                        stair1.add(people.get(j));
                    else
                        stair2.add(people.get(j));
                }
                int time1 = 0, time2 = 0;
                if(stair1.size() != 0) {
                    // 계단 1으로의 거리 측정
                    int[] dist1 = new int[stair1.size()];
                    Stair s1 = stairs.get(0);
                    for (int k = 0; k < stair1.size(); k++) {
                        Person p = stair1.get(k);
                        dist1[k] = Math.abs(p.x - s1.x) + Math.abs(p.y - s1.y);
                    }
                    // 계단 위에 있는 사람
                    int[] now = new int[3];
                    for(int k = 0; k < 3; k++)
                        now[k] = -1;
                    // 계단 앞에서 대기하는 사람
                    Queue<Integer> waiting = new LinkedList<>();
                    // 빠져나간 사람 수
                    int done = 0;
                    // 계단 위 사람 수
                    int sum = 0;
                    while (done < dist1.length) {
                        // 계단 빠져나간 사람 체크
                        for(int k = 0; k < 3; k++){
                            if(now[k] == 1){
                                now[k] = -1;
                                done++;
                                sum--;
                            }
                            else if(now[k] != -1){
                                now[k]--;
                            }
                        }
                        if(done == dist1.length)
                            break;
                        // waiting 중인 사람 넣기
                        while(sum < 3 && waiting.size() > 0){
                            for(int k = 0; k < 3; k++){
                                if(now[k] == -1) {
                                    now[k] = s1.len;
                                    sum++;
                                    waiting.remove();
                                    break;
                                }
                            }
                        }
                        // 시간 된 애는 waiting에 넣어
                        for(int k = 0; k < dist1.length; k++){
                            if(dist1[k] == time1)
                                waiting.add(1);
                        }
                        time1++;
                    }
                }
                if(stair2.size() != 0) {
                    // 계단 2으로의 거리 측정
                    int[] dist2 = new int[stair2.size()];
                    Stair s2 = stairs.get(1);
                    for (int k = 0; k < stair2.size(); k++) {
                        Person p = stair2.get(k);
                        dist2[k] = Math.abs(p.x - s2.x) + Math.abs(p.y - s2.y);
                    }
                    // 계단 위에 있는 사람
                    int[] now = new int[3];
                    for(int k = 0; k < 3; k++)
                        now[k] = -1;
                    // 계단 앞에서 대기하는 사람
                    Queue<Integer> waiting = new LinkedList<>();
                    // 빠져나간 사람 수
                    int done = 0;
                    // 계단 위 사람 수
                    int sum = 0;
                    while (done < dist2.length) {
                        // 계단 빠져나간 사람 체크
                        for(int k = 0; k < 3; k++){
                            if(now[k] == 1){
                                now[k] = -1;
                                done++;
                                sum--;
                            }
                            else if(now[k] != -1) {
                                now[k]--;
                            }
                        }
                        if(done == dist2.length)
                            break;
                        // waiting 중인 사람 넣기
                        while(sum < 3 && waiting.size() > 0){
                            for(int k = 0; k < 3; k++){
                                if(now[k] == -1) {
                                    now[k] = s2.len;
                                    sum++;
                                    waiting.remove();
                                    break;
                                }
                            }
                        }
                        // 시간 된 애는 waiting에 넣어
                        for(int k = 0; k < dist2.length; k++){
                            if(dist2[k] == time2)
                                waiting.add(1);
                        }
                        time2++;
                    }
                }
                max = Math.max(time1, time2);
                ans = Math.min(max, ans);
            }
            System.out.println("#" + T + " " + ans);
        }
    }
}
