import java.util.Arrays;

public class Solution {
    public class Pair implements Comparable<Pair>{
        int len;
        int[] arr;
        public Pair(int len, int[] arr){
            this.len = len;
            this.arr = arr;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.len < that.len)
                return -1;
            else
                return 1;
        }
    }
    public int[] solution(String s) {
        // 맨 앞과 맨 뒤의 {} 제거
        s = s.substring(1, s.length() - 1);
        // 각 tuple은 {a, b, c} 형태
        String[] tuples = s.split("},");

        Pair[] pairs = new Pair[tuples.length];

        for(int i = 0; i < tuples.length; i++){
            String temp;
            if(i != tuples.length - 1)
                temp = tuples[i].substring(1);
            else
                temp = tuples[i].substring(1, tuples[i].length() - 1);
            String[] numbers = temp.split(",");
            int[] nums = new int[numbers.length];
            for(int j = 0; j < numbers.length; j++)
                nums[j] = Integer.parseInt(numbers[j]);
            pairs[i] = new Pair(nums.length, nums);
        }

        Arrays.sort(pairs);
        int[] answer = new int[pairs.length];

        boolean[] check = new boolean[100001];

        for(int i = 0; i < pairs.length; i++){
            Pair p = pairs[i];
            for(int j = 0; j < p.len; j++){
                if(check[p.arr[j]]) continue;
                answer[i] = p.arr[j];
                check[p.arr[j]] = true;
            }
        }


        return answer;
    }
}
