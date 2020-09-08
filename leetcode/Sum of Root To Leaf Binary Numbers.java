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
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        calc(root, 0);
        return ans;
    }
    public void calc(TreeNode node, int curr){
        if(node != null){
            curr = curr * 2 + node.val;
            // leaf node이면 전체 합에 더함
            if(node.left == null && node.right == null){
                ans += curr;
                return;
            }
            calc(node.left, curr);
            calc(node.right, curr);
        }
    }
}
