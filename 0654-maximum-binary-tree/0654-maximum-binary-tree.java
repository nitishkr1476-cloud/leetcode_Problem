class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {

        // Base case
        if (left > right) {
            return null;
        }

        // Find maximum element
        int maxIndex = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Create root using maximum value
        TreeNode root = new TreeNode(nums[maxIndex]);

        // Build left subtree
        root.left = build(nums, left, maxIndex - 1);

        // Build right subtree
        root.right = build(nums, maxIndex + 1, right);

        return root;
    }
}