import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String common = s[0];

        for(int i = 1; i < s.length; i++){
            // 뒤의 쉼표 제거
            String temp = s[i].substring(0, s[i].length() - 1);

            // 변수명 자르기
            int nameEnd = -1;
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j) == '&' || temp.charAt(j) == '[' || temp.charAt(j) == '*') {
                    nameEnd = j;
                    break;
                }
            }
            // 변수명 뒤에 추가 변수형 선언이 없는 경우
            if(nameEnd == -1)
                nameEnd = temp.length();

            String name = temp.substring(0, nameEnd);
            // 앞의 변수명 제거
            temp = temp.substring(nameEnd);

            StringBuilder sb = new StringBuilder();
            sb.append(common);
            for(int j = temp.length() - 1; j >= 0; j--) {
                if(temp.charAt(j) == ']') {
                    sb.append("[]");
                    j--;
                    continue;
                }
                sb.append(temp.charAt(j));
            }
            sb.append(" ").append(name).append(";\n");
            System.out.print(sb.toString());
        }

    }
}
