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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        while(root!=null && (root.val<low || root.val>high)) {
            if(root.val<low) root=root.right;
            if(root.val>high) root=root.left;
        }
        TreeNode node = root;
        while(node!=null){
            while(node.left!=null && node.left.val<low){
                node.left = node.left.right;
            }
            node = node.left;
        }
        node = root;
        while(node!=null){
            while(node.right!=null && node.right.val>high){
                node.right = node.right.left;
            }
            node = node.right;
        }
        return root;
    }
}