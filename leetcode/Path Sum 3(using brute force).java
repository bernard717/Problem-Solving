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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return dfs(root, root.val, sum) +
        pathSum(root.left, sum) +
        pathSum(root.right, sum);
    }
    private int dfs(TreeNode now, int nowSum, int goalSum){
        if(now == null)
            return 0;
        
        return (nowSum == goalSum ? 1 : 0) + (now.left == null ? 0 : dfs(now.left, nowSum + now.left.val, goalSum))
        + (now.right == null ? 0 : dfs(now.right, nowSum + now.right.val, goalSum));
    }
}
