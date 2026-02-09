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
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        return build(list,0,list.size()-1);
    }

    public void traverse(TreeNode root, List<Integer> list){
        if(root==null) return;
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }

    public TreeNode build(List<Integer> list, int l, int r){
        if(l>r) return null;
        int m = l+(r-l)/2;
        return new TreeNode(list.get(m),build(list,l,m-1),build(list,m+1,r));
    }
}