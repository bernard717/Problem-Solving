class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int len = s.length();

        if(len == 1)
            return 1;

        for(int smallLen = 1; smallLen <= len / 2; smallLen++){
            int divided = len / smallLen;
            int left = len % smallLen;

            String temp = s.substring(0, smallLen);
            int num = 1;
            StringBuilder sb = new StringBuilder();

            for(int i = 1; i < divided; i++){
                String next = s.substring(smallLen * i, smallLen * (i + 1));
                if(temp.equals(next))
                    num++;
                else{
                    if(num == 1)
                        sb.append(temp);
                    else
                        sb.append(num).append(temp);
                    temp = next;
                    num = 1;
                }
            }
            if(num == 1)
                sb.append(temp);
            else
                sb.append(num).append(temp);
            if(left != 0)
                sb.append(s.substring(smallLen * divided, s.length()));

            answer = Math.min(sb.toString().length(), answer);
        }


        return answer;
    }
}
