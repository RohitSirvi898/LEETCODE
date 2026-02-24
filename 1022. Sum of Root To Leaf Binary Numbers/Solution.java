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

    public void traverse(TreeNode root, int binanum) {
        binanum = (binanum<<1)+root.val;
        if(root.left==null && root.right==null){
            ans+=binanum;
            return;
        }
        if(root.left!=null) traverse(root.left,binanum);
        if(root.right!=null) traverse(root.right,binanum);
    }

    public int sumRootToLeaf(TreeNode root) {
        traverse(root,0);
        return ans;
    }
}