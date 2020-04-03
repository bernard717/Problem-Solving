class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        int userNum = user_id.length;
        int bannedNum = banned_id.length;

        int[] perm = new int[userNum];
        for(int i = 0; i < bannedNum; i++)
            perm[userNum - 1 - i] = 1;

        do{
            String[] chosen = new String[bannedNum];
            int idx = 0;
            for(int i = 0; i < userNum; i++){
                if(perm[i] == 1)
                    chosen[idx++] = user_id[i];
            }
            // 새로 뽑인 user id와 banned id를 비교할 때 순서를 정하기 위한 배열
            int[] order = new int[bannedNum];
            for(int i = 0; i < bannedNum; i++)
                order[i] = i;

            // 뽑힌 user id가 조건에 맞는 지 확인
            boolean flag = true;
            do{
                flag = true;
                for(int i = 0; i < bannedNum; i++){
                    String user = chosen[order[i]];
                    String banned = banned_id[i];
                    if(user.length() != banned.length()){
                        flag = false;
                        break;
                    }
                    for(int j = 0; j < user.length(); j++){
                        if(user.charAt(j) == '*' || banned.charAt(j) == '*')
                            continue;
                        if(user.charAt(j) != banned.charAt(j)){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag)
                    break;
            }while(next(order));
            if(flag)
                answer++;
        }while(next(perm));



        return answer;
    }
    private boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(j > i){
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            j--;
            i++;
        }
        return true;
    }
}
