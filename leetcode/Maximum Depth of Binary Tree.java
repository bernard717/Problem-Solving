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
    static int ans;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        ans = -1;
        dfs(root, 1);
        
        return ans;
    }
    public void dfs(TreeNode t, int depth){
        if(t.left == null && t.right == null){
            ans = Math.max(ans, depth);
            return;
        }
        if(t.left != null)
            dfs(t.left, depth + 1);
        if(t.right != null)
            dfs(t.right, depth + 1);
    }
}
