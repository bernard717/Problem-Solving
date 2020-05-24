class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int ans = 0;
        
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]){
                int mul = 2;
                while(i * mul <= n){
                    isPrime[i * mul] = true;
                    mul++;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(!isPrime[i])
                ans++;
        }
        return ans;
    }
}
