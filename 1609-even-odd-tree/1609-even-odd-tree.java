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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        boolean oddLevel = true;
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            int prev = oddLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();

                if (oddLevel && node.val % 2 == 0) return false;
                if (!oddLevel && node.val % 2 != 0) return false;
                if (oddLevel && node.val <= prev) return false;
                if (!oddLevel && node.val >= prev) return false;

                prev = node.val;

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            oddLevel = !oddLevel;
        }
        return true;
    }
}