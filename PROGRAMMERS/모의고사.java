import java.util.Arrays;

class Solution {
    class Pair implements Comparable<Pair>{
        int num, idx;

        public Pair(int num, int idx){
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.num < that.num)
                return -1;
            else if(this.num == that.num){
                if(this.idx > that.idx)
                    return -1;
                else
                    return 1;
            }
            else
                return 1;
        }
    }
    public int[] solution(int[] answers) {
        int[] answer = new int[1];

        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] sums = {0, 0, 0};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i % 5]) sums[0]++;
            if(answers[i] == second[i % 8]) sums[1]++;
            if(answers[i] == third[i % 10]) sums[2]++;
        }

        
        Pair[] pairs = new Pair[3];

        for(int i = 0; i < 3; i++)
            pairs[i] = new Pair(sums[i], i + 1);

        Arrays.sort(pairs);

        answer[0] = pairs[2].idx;

        if(pairs[2].num == pairs[1].num) {
            answer = new int[2];
            answer[0] = pairs[2].idx;
            answer[1] = pairs[1].idx;
        }
        else
            return answer;

        if(pairs[2].num == pairs[0].num) {
            answer = new int[3];
            answer[0] = pairs[2].idx;
            answer[1] = pairs[1].idx;
            answer[2] = pairs[0].idx;
        }

        return answer;
    }
}
