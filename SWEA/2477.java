import java.awt.geom.CubicCurve2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static class Customer implements Comparable<Customer>{
        int recep, repair, id, time;
        public Customer(int recep, int repair, int id, int time){
            this.recep = recep;
            this.repair = repair;
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Customer that) {
            if(this.id < that.id)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            int ans = 0;
            String[] line = br.readLine().split(" ");
            int recepNum = Integer.parseInt(line[0]);
            int repairNum = Integer.parseInt(line[1]);
            int customerNum = Integer.parseInt(line[2]);
            int A = Integer.parseInt(line[3]);
            int B = Integer.parseInt(line[4]);

            int[] recepTime = new int[recepNum];
            line = br.readLine().split(" ");
            for(int i = 0; i < recepNum; i++)
                recepTime[i] = Integer.parseInt(line[i]);

            int[] repairTime = new int[repairNum];
            line = br.readLine().split(" ");
            for(int i = 0; i < repairNum; i++)
                repairTime[i] = Integer.parseInt(line[i]);

            int[] visitTime = new int[customerNum];
            line = br.readLine().split(" ");
            for(int i = 0; i < customerNum; i++)
                visitTime[i] = Integer.parseInt(line[i]);

            // 접수 창구에서 진행하고 있는 고객의 시간
            Customer[] usingRecep = new Customer[recepNum];

            // 정비 창구에서 진행하고 있는 고객의 시간
            Customer[] usingRepair = new Customer[repairNum];

            // 접수를 기다릴 때 id가 낮은 순서대로 queue에서 뽑아내는 우선순위 큐
            PriorityQueue<Customer> waitingRecep = new PriorityQueue<>();

            // 정비를 기다릴 때 기다린 순서대로 queue에 넣음
            Queue<Customer> waitingRepair = new LinkedList<>();

            // 정비까지 완료한 고객의 수
            int done = 0;
            // 접수, 정비 중인 고객의 수
            int doingRecep = 0;
            int doingRepair = 0;
            // 현재 시간
            int time = 0;

            while(done < customerNum){
                // 정비 창구에 있는 고객의 시간을 전부 +1 해준 후에,
                // 정비 창구에서 시간 완료된 고객은 나감
                for(int i = 0; i < repairNum; i++){
                    // 창구가 비어있으면 pass
                    if(usingRepair[i] == null) continue;
                    usingRepair[i].time++;
                    if(usingRepair[i].time == repairTime[i]){
                        Customer c = usingRepair[i];
                        // 주어진 조건의 창구들을 이용했으면 id값을 추가
                        if(c.recep == A && c.repair == B)
                            ans += c.id;
                        // 해당 정비 창구는 비워둠
                        usingRepair[i] = null;
                        done++;
                        doingRepair--;
                    }
                }
                // 접수 창구에서 끝난 고객은 일단 임시 우선순위큐에 저장
                ArrayList<Customer> temp = new ArrayList<>();
                // 같은 방식으로 접수 창구도 처리
                for(int i = 0; i < recepNum; i++){
                    if(usingRecep[i] == null) continue;
                    usingRecep[i].time++;
                    if(usingRecep[i].time == recepTime[i]){
                        temp.add(usingRecep[i]);
                        usingRecep[i] = null;
                        doingRecep--;
                    }
                }
                Collections.sort(temp, new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        if(o1.recep < o2.recep)
                            return -1;
                        else
                            return 1;
                    }
                });
                // 접수 완료된 고객들에 대해 정비를 기다리는 큐에 넣음
                for(int i = 0; i < temp.size(); i++)
                    waitingRepair.add(temp.get(i));

                // 정비 큐에서 기다리는 고객들을 정비 창구에 넣음
                while(doingRepair < repairNum && !waitingRepair.isEmpty()){
                    Customer c = waitingRepair.remove();
                    // 정비 창구 중 빈 곳에 넣음
                    for(int i = 0; i < repairNum; i++){
                        if(usingRepair[i] == null){
                            usingRepair[i] = new Customer(c.recep, i + 1, c.id, 0);
                            doingRepair++;
                            break;
                        }
                    }
                }

                // 새로 도착한 고객들을 접수 창구 waiting queue에 넣음
                for(int i = 0; i < customerNum; i++){
                    if(visitTime[i] == time)
                        waitingRecep.add(new Customer(0, 0, i + 1, 0));
                }

                // 접수 창구를 기다리는 고객들을 접수 창구에 넣음
                while(doingRecep < recepNum && !waitingRecep.isEmpty()){
                    Customer c = waitingRecep.remove();
                    // 정비 창구 중 빈 곳에 넣음
                    for(int i = 0; i < recepNum; i++){
                        if(usingRecep[i] == null){
                            usingRecep[i] = c;
                            usingRecep[i].recep = i + 1;
                            doingRecep++;
                            break;
                        }
                    }
                }
                time++;
            }

            if(ans == 0)
                ans = -1;

            System.out.println("#" + T + " " + ans);
        }
    }
}
