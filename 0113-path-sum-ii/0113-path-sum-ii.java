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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        dfs(root,temp,targetSum);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> temp, int target){
        if(root==null) return;
        if(root.left==null && root.right==null ){
            if(root.val==target){
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        
        temp.add(root.val);
        dfs(root.left,temp,target-root.val);
        dfs(root.right,temp,target-root.val);
        temp.remove(temp.size()-1);
    }
}