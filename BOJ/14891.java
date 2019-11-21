import java.util.*;
import java.io.*;
public class Main {
    static int[] one;
    static int[] two;
    static int[] three;
    static int[] four;
    static int start1 = 100, start2 = 100, start3 = 100, start4 = 100;
    public static void go(int which, int dir, boolean[] judge){
        clock(which, dir);
        if(which == 1 || which == 4)
            return;
        if (!judge[which - 1])
            go1(which + 1, dir * -1, judge);
        if (!judge[which - 2])
            go4(which - 1, dir * -1, judge);
    }
    public static void go1(int which, int dir, boolean[] judge){
        clock(which, dir);
        if(which == 4)
            return;
        if (!judge[which - 1])
            go1(which + 1, dir * -1, judge);
    }
    public static void go4(int which, int dir, boolean[] judge){
        clock(which, dir);
        if(which == 1)
            return;
        if (!judge[which - 2])
            go4(which - 1, dir * -1, judge);
    }
    public static void clock(int which, int dir){
        if(dir == 1) {
            switch (which) {
                case 1:
                    one[start1 - 1] = one[start1 + 7];
                    start1--;
                    break;
                case 2:
                    two[start2 - 1] = two[start2 + 7];
                    start2--;
                    break;
                case 3:
                    three[start3 - 1] = three[start3 + 7];
                    start3--;
                    break;
                case 4:
                    four[start4 - 1] = four[start4 + 7];
                    start4--;
            }
        }
        else{
            switch (which){
                case 1:
                    one[start1 + 8] = one[start1];
                    start1++;
                    break;
                case 2:
                    two[start2 + 8] = two[start2];
                    start2++;
                    break;
                case 3:
                    three[start3 + 8] = three[start3];
                    start3++;
                    break;
                case 4:
                    four[start4 + 8] = four[start4];
                    start4++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        one = new int[210];
        two = new int[210];
        three = new int[210];
        four = new int[210];
        for(int i = 0; i < 4; i++){
            String line = br.readLine();
            for(int j = 100; j < 108; j++){
                if(i == 0)
                    one[j] = line.charAt(j - 100) - '0';
                else if(i == 1)
                    two[j] = line.charAt(j - 100) - '0';
                else if(i == 2)
                    three[j] = line.charAt(j - 100) - '0';
                else
                    four[j] = line.charAt(j - 100) - '0';
            }
        }
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            String[] line = br.readLine().split(" ");
            int which = Integer.parseInt(line[0]);
            int dir = Integer.parseInt(line[1]);
            boolean[] judge = new boolean[3];
            judge[0] = one[start1 + 2] == two[start2 + 6];
            judge[1] = two[start2 + 2] == three[start3 + 6];
            judge[2] = three[start3 + 2] == four[start4 + 6];
            if(which == 1)
                go1(which, dir, judge);
            else if(which == 4)
                go4(which, dir, judge);
            else
                go(which, dir, judge);
        }
        int ans = one[start1] + two[start2] * 2 + three[start3] * 4 + four[start4] * 8;
        System.out.println(ans);
    }
}
