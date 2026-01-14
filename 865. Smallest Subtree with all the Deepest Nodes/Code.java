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
    public int dfs(TreeNode root,int level){
        if(root==null) return level;
        return Math.max(dfs(root.left,level+1),dfs(root.right,level+1));
    }

    public TreeNode findNode(TreeNode root,int level,int maxdepth){
        if(root==null) return null;
        if(level==maxdepth-1) return root;

        TreeNode l=findNode(root.left,level+1,maxdepth);
        TreeNode r=findNode(root.right,level+1,maxdepth);

        if(l!=null && r!=null) return root;
        return (l!=null)?l:r;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxdepth=dfs(root,0);
        TreeNode ans=findNode(root,0,maxdepth);
        return ans;
    }
}