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
    int maximum = 0;
    public int maxDepth(TreeNode root) {
        traversal(root,1);
        return maximum;
    }

    public void traversal(TreeNode node, int level){
        if(node==null) return ;
        maximum = Math.max(maximum,level);
        traversal(node.left,level+1);
        traversal(node.right,level+1);
    }
}