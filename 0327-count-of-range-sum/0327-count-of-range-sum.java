
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        
        // Build prefix sum
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        return mergeSort(prefix, 0, prefix.length, lower, upper);
    }
    
    private int mergeSort(long[] prefix, int low, int high, int lower, int upper) {
        if (high - low <= 1) return 0;
        
        int mid = (low + high) / 2;
        int count = mergeSort(prefix, low, mid, lower, upper)
                  + mergeSort(prefix, mid, high, lower, upper);
        
        int j = mid, k = mid;
        
        // Count valid ranges
        for (int i = low; i < mid; i++) {
            while (k < high && prefix[k] - prefix[i] < lower) k++;
            while (j < high && prefix[j] - prefix[i] <= upper) j++;
            count += j - k;
        }
        
        // Merge step (sort the array)
        long[] temp = new long[high - low];
        int i = low, r = mid, t = 0;
        
        while (i < mid && r < high) {
            if (prefix[i] <= prefix[r]) {
                temp[t++] = prefix[i++];
            } else {
                temp[t++] = prefix[r++];
            }
        }
        
        while (i < mid) temp[t++] = prefix[i++];
        while (r < high) temp[t++] = prefix[r++];
        
        System.arraycopy(temp, 0, prefix, low, temp.length);
        
        return count;
    }
}