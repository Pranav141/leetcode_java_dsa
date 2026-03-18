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
    public Map<Integer,Integer> mp = new HashMap<>();
    public int idx ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //nlr - preorder - node left right 
        //lnr - inorder - left node right
        int i=0;
        for(int ele:inorder){
            mp.put(ele,i++);
        }
        idx = 0;
        return build(preorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int start,int end){
        if(start>end) return null;
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int mid = mp.get(rootVal);
        TreeNode left = build(preorder,start,mid-1);
        TreeNode right = build(preorder,mid+1,end);
        root.left = left;
        root.right = right;
        return root;

    }
}