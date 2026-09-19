class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;

        for (int i = 0; i <= n - m - 1; i++) {
            boolean match = true;

            for (int k = 0; k < m; k++) {
                int diff;

                if (nums[i + k + 1] > nums[i + k]) {
                    diff = 1;
                } else if (nums[i + k + 1] == nums[i + k]) {
                    diff = 0;
                } else {
                    diff = -1;
                }

                if (diff != pattern[k]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }
}