class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        int left = -1, right = -2; // ensures 0 if already sorted
        int max = nums[0], min = nums[n - 1];
        
        // Left to right: track max
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                right = i;
            }
        }
        
        // Right to left: track min
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                left = i;
            }
        }
        
        return right - left + 1;
    }
}
