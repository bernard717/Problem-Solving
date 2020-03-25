import java.util.Arrays;

class Solution {
    class Stage implements Comparable<Stage>{
        int idx, num, people;
        double rate;
        public Stage(int idx, int num, int people){
            this.idx = idx;
            this.num = num;
            this.people = people;
            if(num == 0 && people == 0)
                this.rate = 0;
            else
                this.rate = (double) num / people;
        }

        @Override
        public int compareTo(Stage o) {
            if(this.rate < o.rate)
                return 1;
            else if(this.rate == o.rate){
                if(this.idx < o.idx)
                    return -1;
                else
                    return 1;
            }
            else return -1;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] people = new int[N];

        int max = -1;

        for(int i = 0; i < stages.length; i++){
            max = Math.max(max, stages[i]);
            if(stages[i] <= N)
                people[stages[i] - 1]++;
        }

        Stage[] arr = new Stage[N];

        int left = stages.length;
        for(int i = 0; i < N; i++){
            if(i > max)
                arr[i] = new Stage(i + 1, 0, 0);
            arr[i] = new Stage(i + 1, people[i], left);
            left -= people[i];
        }
        Arrays.sort(arr);
        for(int i = 0; i < N; i++)
            answer[i] = arr[i].idx;

        return answer;
    }
}
