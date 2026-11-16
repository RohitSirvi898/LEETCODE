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
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public void helper(TreeNode root, int sum){
        sum = (sum*10)+root.val;
        if(root.left==null && root.right==null){
            ans+=sum;
            return;
        }
        
        if(root.left!=null) helper(root.left,sum);
        if(root.right!=null) helper(root.right,sum);
    }
}