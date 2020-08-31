/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> map;
    int max;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        max = -1;
        map = new HashMap<>();
        getSum(root);
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == max)
                list.add(key);
        }
        int[] ans = new int[list.size()];
        int idx = 0;
        for(int val : list)
            ans[idx++] = val;
        return ans;
    }
    public int getSum(TreeNode root){
        if(root == null)
            return 0;
        int temp = getSum(root.left) + root.val + getSum(root.right);
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        max = Math.max(max, map.get(temp));
        return temp;
    }
}
