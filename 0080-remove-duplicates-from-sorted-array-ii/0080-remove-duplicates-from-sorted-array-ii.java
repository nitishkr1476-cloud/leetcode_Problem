class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;

        for (int num : nums) {
            // Allow the number if:
            // 1. We have fewer than 2 elements, OR
            // 2. Current number is different from nums[k - 2]
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}
