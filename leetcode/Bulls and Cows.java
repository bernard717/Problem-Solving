class Solution {
    public String getHint(String secret, String guess) {
        ArrayList<Integer>[] arr1 = new ArrayList[10];
        ArrayList<Integer>[] arr2 = new ArrayList[10];
        for(int i = 0; i < 10; i++){
            arr1[i] = new ArrayList<>();
            arr2[i] = new ArrayList<>();
        }
        
        int len = secret.length();
        for(int i = 0; i < len; i++){
            arr1[secret.charAt(i) - '0'].add(i);
            arr2[guess.charAt(i) - '0'].add(i);
        }
        
        int bulls = 0, cows = 0;
        
        for(int i = 0; i < 10; i++){
            int min = Math.min(arr1[i].size(), arr2[i].size());
            if(min >= 1){
                int tmp = getNum(arr1[i], arr2[i]);
                bulls += tmp;
                cows += (min - tmp);
            }
        }
        return bulls + "A" + cows + "B";
    }
    public int getNum(ArrayList<Integer> one, ArrayList<Integer> two){
        int len1 = one.size(), len2 = two.size();
        int p1 = 0, p2 = 0;
        // 각 list에서 숫자가 같은 값의 개수
        int res = 0;
        
        while(p1 < len1 && p2 < len2){
            if(one.get(p1) < two.get(p2))
                p1++;
            else if(one.get(p1) > two.get(p2))
                p2++;
            else{
                res++;
                p1++;
                p2++;
            }
        }
        return res;
    }
}
