class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][] dp = new boolean[200][200];
        
        int x = 5, y = 5;
        
        for(char c : dirs.toCharArray()){
            int now = x * 11 + y;
            if(c == 'U'){
                int nx = x - 1;
                int ny = y;
                if(outOfBound(nx, ny)) continue;
                x = nx;
                y = ny;
                int next = nx * 11 + ny;
                if(dp[now][next]) continue;
                answer++;
                dp[now][next] = true;
            }
            else if(c == 'D'){
                int nx = x + 1;
                int ny = y;
                if(outOfBound(nx, ny)) continue;
                x = nx;
                y = ny;
                int next = nx * 11 + ny;
                if(dp[now][next]) continue;
                answer++;
                dp[now][next] = true;
            }
            else if(c == 'L'){
                int nx = x;
                int ny = y - 1;
                if(outOfBound(nx, ny)) continue;
                x = nx;
                y = ny;
                int next = nx * 11 + ny;
                if(dp[now][next]) continue;
                answer++;
                dp[now][next] = true;
            }
            else{
                int nx = x;
                int ny = y + 1;
                if(outOfBound(nx, ny)) continue;
                x = nx;
                y = ny;
                int next = nx * 11 + ny;
                if(dp[now][next]) continue;
                answer++;
                dp[now][next] = true;
            }
        }  
        return answer;
    }
    public boolean outOfBound(int x, int y){
        return x > 10 || y > 10 || x < 0 || y < 0; 
    }
}
