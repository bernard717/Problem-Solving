import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] numbers1 = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            numbers1[i] = Integer.toString(numbers[i]);

        Arrays.sort(numbers1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(numbers1[0].equals("0")) return "0";

        for(int i = 0; i < numbers.length; i++)
            sb.append(numbers1[i]);
        return sb.toString();
    }

}
