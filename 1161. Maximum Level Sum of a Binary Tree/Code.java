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
    HashMap<Integer,Integer> map = new HashMap<>();

    public void traverse(TreeNode root,int level){
        if(root==null) return;
        map.put(level,map.getOrDefault(level,0)+root.val);
        // System.out.println(level+" "+map.get(level));
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }

    public int maxLevelSum(TreeNode root) {
        traverse(root,1);
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=1;i<=map.size();i++){
            if(map.get(i)>max){
                max=map.get(i);
                ans=i;
            }
            // System.out.println(i+" "+map.get(i));
        }
        return ans;
    }
}