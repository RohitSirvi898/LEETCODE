/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return " ";
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        StringBuilder s = new StringBuilder();

        while (!que.isEmpty()) {

            TreeNode node = que.poll();

            if (node == null) {
                s.append(" ");
                s.append(",");
                continue;
            }

            s.append(node.val);
            s.append(",");

            que.offer(node.left);
            que.offer(node.right);
        }

        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] arr = data.split(",");
        if(arr[0].equals(" ")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int i = 1;

        while (!que.isEmpty() && i < arr.length) {

            TreeNode node = que.poll();

            // Left child
            if (!arr[i].equals(" ")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                que.offer(node.left);
            }

            i++;

            // Right child
            if (i < arr.length && !arr[i].equals(" ")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                que.offer(node.right);
            }

            i++;
        }

        return root;
    }
    // public TreeNode createTree(String[] arr,int idx){
    //     if(idx>=arr.length || arr[idx].equals(" ")) return null;
    //     TreeNode root = new TreeNode(Integer.valueOf(arr[idx]));
    //     root.left = createTree(arr,2*idx+1);
    //     root.right = createTree(arr,2*idx+2);
    //     return root;
    // }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;