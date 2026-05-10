class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        int[] ans = new int[k];

        // Try all possible splits
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {

            int[] part1 = pickMax(nums1, i);
            int[] part2 = pickMax(nums2, k - i);

            int[] candidate = merge(part1, part2);

            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }

        return ans;
    }

    // Pick maximum subsequence of length k
    private int[] pickMax(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];

        int top = -1;
        int drop = n - k;

        for (int num : nums) {

            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }

            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    // Merge two arrays into maximum number
    private int[] merge(int[] nums1, int[] nums2) {

        int[] merged = new int[nums1.length + nums2.length];

        int i = 0, j = 0, r = 0;

        while (i < nums1.length || j < nums2.length) {

            if (greater(nums1, i, nums2, j)) {
                merged[r++] = nums1[i++];
            } else {
                merged[r++] = nums2[j++];
            }
        }

        return merged;
    }

    // Compare remaining parts lexicographically
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {

        while (i < nums1.length &&
               j < nums2.length &&
               nums1[i] == nums2[j]) {

            i++;
            j++;
        }

        return j == nums2.length ||
               (i < nums1.length && nums1[i] > nums2[j]);
    }
}
