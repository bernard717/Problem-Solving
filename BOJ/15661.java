import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] s = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                s[i][j] = Integer.parseInt(line[j]);
        }
        // 각 팀 멤버를 저장하는 arraylist
        ArrayList<Integer> teamStart, teamLink;

        // 각 팀의 능력치 합, 각 팀의 멤버 수
        int sumStart, sumLink, lenStart, lenLink;

        // 각 팀 능력치 합 간의 차이 최솟값
        int min = Integer.MAX_VALUE;

        // {0, 0, ...}과 {1, 1, ...}을 제외한 모든 부분집합
        for(int i = 1; i < Math.pow(2, n) - 1; i++){
            teamStart = new ArrayList<>();
            teamLink = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & 1 << j) == 1 << j)
                    teamStart.add(j);
                else
                    teamLink.add(j);
            }
            sumStart = 0;
            sumLink = 0;

            lenStart = teamStart.size();
            lenLink = teamLink.size();

            for(int j = 0; j < lenStart - 1; j++){
                for(int k = j; k < lenStart; k++) {
                    sumStart += s[teamStart.get(j)][teamStart.get(k)];
                    sumStart += s[teamStart.get(k)][teamStart.get(j)];
                }
            }
            for(int j = 0; j < lenLink - 1; j++){
                for(int k = j; k < lenLink; k++) {
                    sumLink += s[teamLink.get(j)][teamLink.get(k)];
                    sumLink += s[teamLink.get(k)][teamLink.get(j)];
                }
            }
            min = Math.min(min, Math.abs(sumStart - sumLink));
        }
        System.out.print(min);
    }
}
