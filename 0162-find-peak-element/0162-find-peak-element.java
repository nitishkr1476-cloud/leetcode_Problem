
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;      // peak is in left half (including mid)
            } else {
                left = mid + 1;   // peak is in right half
            }
        }

        return left; // or right (both are same here)
    }
}