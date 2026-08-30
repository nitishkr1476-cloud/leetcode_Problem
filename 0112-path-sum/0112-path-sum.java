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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // If tree is empty
        if (root == null) {
            return false;
        }

        // If current node is a leaf
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Subtract current node's value
        targetSum -= root.val;

        // Check left or right subtree
        return hasPathSum(root.left, targetSum) ||
               hasPathSum(root.right, targetSum);
    }
}