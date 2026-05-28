class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        long pairs = 0;
        long ans = 0;
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            
            int count = freq.getOrDefault(nums[right], 0);
            pairs += count;
            freq.put(nums[right], count + 1);
            
            while (pairs >= k) {
                ans += (n - right);
                
                int leftCount = freq.get(nums[left]);
                freq.put(nums[left], leftCount - 1);
                
                pairs -= (leftCount - 1);
                
                left++;
            }
        }
        
        return ans;
    }
}
