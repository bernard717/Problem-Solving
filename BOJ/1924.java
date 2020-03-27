import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int month = Integer.parseInt(s[0]);
        int day = Integer.parseInt(s[1]);

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] name = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int days = 0;
        for(int i = 0; i < month; i++)
            days += months[i];

        days += day;

        System.out.print(name[days % 7]);
    }
}
