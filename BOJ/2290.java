import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int s = Integer.parseInt(line[0]);

        String num = line[1];

        // 공백 * (s + 2)
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s + 2; i++)
            sb.append(" ");
        String a = sb.toString();

        // 공백 --- 공백
        sb = new StringBuilder();
        sb.append(" ");
        for(int i = 0; i < s; i++)
            sb.append("-");
        sb.append(" ");
        String b = sb.toString();

        // 공백 (s + 1)개 |
        sb = new StringBuilder();
        for(int i = 0; i < s + 1; i++)
            sb.append(" ");
        sb.append("|");
        String c = sb.toString();

        // | 공백 s개 |
        sb = new StringBuilder();
        sb.append("|");
        for(int i = 0; i < s; i++)
            sb.append(" ");
        sb.append("|");
        String d = sb.toString();

        // | 공백 (s + 1)개
        sb = new StringBuilder();
        sb.append("|");
        for(int i = 0; i < s + 1; i++)
            sb.append(" ");
        String e = sb.toString();

        String[][] numbers = new String[10][2 * s + 3];
        // 숫자 0
        numbers[0][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[0][i] = d;
        numbers[0][s + 1] = a;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[0][i] = d;
        numbers[0][2 * s + 2] = b;
        // 숫자 1
        numbers[1][0] = a;
        for(int i = 1; i < s + 1; i++)
            numbers[1][i] = c;
        numbers[1][s + 1] = a;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[1][i] = c;
        numbers[1][2 * s + 2] = a;
        // 숫자 2
        numbers[2][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[2][i] = c;
        numbers[2][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[2][i] = e;
        numbers[2][2 * s + 2] = b;
        // 숫자 3
        numbers[3][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[3][i] = c;
        numbers[3][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[3][i] = c;
        numbers[3][2 * s + 2] = b;
        // 숫자 4
        numbers[4][0] = a;
        for(int i = 1; i < s + 1; i++)
            numbers[4][i] = d;
        numbers[4][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[4][i] = c;
        numbers[4][2 * s + 2] = a;
        // 숫자 5
        numbers[5][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[5][i] = e;
        numbers[5][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[5][i] = c;
        numbers[5][2 * s + 2] = b;
        // 숫자 6
        numbers[6][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[6][i] = e;
        numbers[6][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[6][i] = d;
        numbers[6][2 * s + 2] = b;
        // 숫자 7
        numbers[7][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[7][i] = c;
        numbers[7][s + 1] = a;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[7][i] = c;
        numbers[7][2 * s + 2] = a;
        // 숫자 8
        numbers[8][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[8][i] = d;
        numbers[8][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[8][i] = d;
        numbers[8][2 * s + 2] = b;
        // 숫자 9
        numbers[9][0] = b;
        for(int i = 1; i < s + 1; i++)
            numbers[9][i] = d;
        numbers[9][s + 1] = b;
        for(int i = s + 2; i < 2 * s + 2; i++)
            numbers[9][i] = c;
        numbers[9][2 * s + 2] = b;

        for(int j = 0; j < 2 * s + 3; j++) {
            for (int i = 0; i < num.length(); i++) {
                int what = num.charAt(i) - '0';
                System.out.print(numbers[what][j] + " ");
            }
            System.out.println();
        }

    }
}
