import java.util.*;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            StringBuilder subarray = new StringBuilder();

            for (int j = i; j < n; j++) {

                if (nums[j] % p == 0) {
                    count++;
                }

                // More than k divisible elements
                if (count > k) {
                    break;
                }

                subarray.append(nums[j]).append(",");

                // Store the subarray
                set.add(subarray.toString());
            }
        }

        return set.size();
    }
}