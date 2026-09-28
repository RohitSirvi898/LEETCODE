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
    class Pair{
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        if(root==null) return 0;
        que.add(new Pair(root,0));
        int ans = 1;
        while(!que.isEmpty()){
            int size = que.size();
            long start=-1;
            long end=-1;
            for(int i=0;i<size;i++){
                Pair curr = que.poll();
                TreeNode node = curr.node;
                long idx = curr.idx;
                if(node.left!=null) {
                    if(start==-1){
                        start = 2*idx+1;
                    }
                    else{
                        end = 2*idx+1;
                    }
                    que.offer(new Pair(node.left,2*idx+1));
                }
                if(node.right!=null) {
                    if(start==-1){
                        start = 2*idx+2;
                    }
                    else{
                        end = 2*idx+2;
                    }
                    que.offer(new Pair(node.right,2*idx+2));
                }
            }
            if(start!=-1 && end!=-1) ans=Math.max(ans,(int)(end-start+1));
        } 
        return ans;
    }
}