class Solution {
    long total = 0;
    long max = 0;

    public int maxProduct(TreeNode root) {
        total = transform(root);
        help(root);
        return (int)(max % 1_000_000_007);
    }

    public long transform(TreeNode root) {
        if (root == null) return 0;

        long l = transform(root.left);
        long r = transform(root.right);

        root.val = (int)(l + r + root.val); // value itself fits int
        return root.val;
    }

    public void help(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            max = Math.max(max,
                    (long) root.left.val * (total - root.left.val));
        }

        if (root.right != null) {
            max = Math.max(max,
                    (long) root.right.val * (total - root.right.val));
        }

        help(root.left);
        help(root.right);
    }
}