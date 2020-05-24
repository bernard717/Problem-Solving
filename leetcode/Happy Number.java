class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n)){
            int temp = 0;
            while(n != 0){
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            if(temp == 1)
                return true;
            n = temp;
        }
        return false;
    }
}
