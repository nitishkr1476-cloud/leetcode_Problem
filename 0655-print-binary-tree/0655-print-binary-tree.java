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

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rows = height + 1;
        int cols = (1 << (height + 1)) - 1;

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }

        fill(root, res, 0, (cols - 1) / 2, height);

        return res;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void fill(TreeNode node, List<List<String>> res, int r, int c, int height) {
        if (node == null) {
            return;
        }

        res.get(r).set(c, String.valueOf(node.val));

        int offset = 1 << (height - r - 1);

        if (node.left != null) {
            fill(node.left, res, r + 1, c - offset, height);
        }

        if (node.right != null) {
            fill(node.right, res, r + 1, c + offset, height);
        }
    }
}
