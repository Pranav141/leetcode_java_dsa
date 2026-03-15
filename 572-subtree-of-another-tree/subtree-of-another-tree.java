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
    public void findRoot(TreeNode root,TreeNode subRoot,Queue<TreeNode> q){
        if(root == null){
            return;
        }
        if(root.val == subRoot.val){
            q.add(root);
        }
        findRoot(root.left,subRoot,q);
        findRoot(root.right,subRoot,q);
    }
    public boolean isSame(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean left = isSame(p.left,q.left);
        boolean right = isSame(p.right,q.right);
        return left && right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new ArrayDeque<>();
        findRoot(root,subRoot,q);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            boolean res = isSame(temp,subRoot);
            if(res) return res;
        }
        return false;
    }
}