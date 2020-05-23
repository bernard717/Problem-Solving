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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return recur(nums, 0, nums.length - 1);
    }
    public TreeNode recur(int[] nums, int st, int en){
        if(st > en)
            return null;
        int mid = st + (en - st) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, st, mid - 1);
        root.right = recur(nums, mid + 1, en);
        
        return root;
    }
}
