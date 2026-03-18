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
    public int max = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);

        int tmax = Math.max(left+right+root.val,Math.max(left,right)+root.val);
        tmax = Math.max(tmax,root.val);
        max = Math.max(max,tmax);
        return Math.max(root.val,root.val+Math.max(left,right));
    }

    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;       
    }
}