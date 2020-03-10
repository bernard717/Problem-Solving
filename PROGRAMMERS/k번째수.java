import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int num = commands.length;
        int[] answer = new int[num];

        for(int i = 0; i < num; i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int idx = commands[i][2] - 1;

            int len = end - start + 1;

            int[] temp = new int[len];
            for(int j = 0; j < len; j++)
                temp[j] = array[start + j];

            Arrays.sort(temp);

            answer[i] = temp[idx];
        }


        return answer;
    }
}
