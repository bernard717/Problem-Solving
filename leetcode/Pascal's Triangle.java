class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0)
            return ans;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        if(numRows == 1)
            return ans;
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        ans.add(second);
        for(int i = 3; i <= numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0; j < i - 2; j++)
                temp.add(ans.get(i - 2).get(j) + ans.get(i - 2).get(j + 1));
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}
