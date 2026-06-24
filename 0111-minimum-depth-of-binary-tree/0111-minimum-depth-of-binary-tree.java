class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If left subtree is missing, recur for right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If right subtree is missing, recur for left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If both children exist, take the minimum depth
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}