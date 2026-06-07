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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashMap<Integer,Integer> node = new HashMap<>();
        int root = -1;

        for(int[] d: descriptions){
            int parent = d[0];
            int child = d[1];
            int isleft = d[2];

            if(!map.containsKey(parent)) map.put(parent,new TreeNode(parent));
            if(!map.containsKey(child)) map.put(child,new TreeNode(child));
            if(isleft==1) map.get(parent).left = map.get(child);
            else map.get(parent).right = map.get(child);

            if(node.getOrDefault(parent,0)!=-1){
                node.put(parent,1);
            }
            node.put(child,-1);
        }

        for(var entry:node.entrySet()){
            if(entry.getValue() == 1){
                root = entry.getKey();
                break;
            }
        }

        return map.get(root);
    }
}