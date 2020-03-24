import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Tower {
        int height, idx;
        public Tower(int height, int idx){
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] towers = new int[num];

        for(int i = 0; i < num; i++)
            towers[i] = Integer.parseInt(s[i]);

        Stack<Tower> stack = new Stack<>();
        stack.push(new Tower(towers[0], 0));

        int[] answer = new int[num];
        int idx = 0;

        for(int i = 1; i < num; i++){
            while(!stack.isEmpty() && stack.peek().height <= towers[i]){
                Tower t = stack.pop();
                if(!stack.isEmpty())
                    answer[t.idx] = stack.peek().idx + 1;
                else
                    answer[t.idx] = 0;
            }
            stack.push(new Tower(towers[i], i));
        }
        while(!stack.isEmpty()){
            Tower t = stack.pop();
            if(!stack.isEmpty())
                answer[t.idx] = stack.peek().idx + 1;
            else
                answer[t.idx] = 0;
        }
        for(int i = 0; i < num; i++)
            System.out.print(answer[i] + " ");
    }
}
