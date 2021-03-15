class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<List<Integer>>> dp = new ArrayList<>();
        // target에 대한 정답을 구하기 전에 1부터 target까지의 정답을 구함
        for(int i = 1; i <= target; i++){
            // i에 대한 정답
            List<List<Integer>> newList = new ArrayList<>();
            for(int j = 0; j < candidates.length && candidates[j] <= i; j++){
                // i와 candidates[j]의 값이 같은 경우
                if(i == candidates[j])
                    newList.add(Arrays.asList(candidates[j]));
                else{
                    for(List<Integer> l : dp.get(i - candidates[j] - 1)){
                        if(candidates[j] <= l.get(0)){
                            List c1 = new ArrayList<>();
                            c1.add(candidates[j]);
                            c1.addAll(l);
                            newList.add(c1);
                        }
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(target - 1);
    }
}
