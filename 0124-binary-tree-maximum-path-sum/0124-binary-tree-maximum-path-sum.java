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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Maximum contribution from left and right subtree
        // Ignore negative sums
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Path passing through current node
        int currentPathSum = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return maximum one-side path to parent
        return node.val + Math.max(left, right);
    }
}