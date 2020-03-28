import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int n = board.length;

        int[] top = new int[n];
        for(int i = 0; i < n; i++)
            top[i] = -1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(top[j] != -1) continue;
                if(board[i][j] == 0) continue;
                top[j] = i;
            }
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++){
            int where = moves[i] - 1;
            if(top[where] == -1) continue;
            int out = board[top[where]][where];
            board[top[where]][where] = 0;
            top[where] = top[where] == n - 1 ? -1 : top[where] + 1;
            if(!stack.isEmpty() && stack.peek() == out){
                stack.pop();
                answer += 2;
            }
            else
                stack.push(out);
        }
        return answer;
    }
}
