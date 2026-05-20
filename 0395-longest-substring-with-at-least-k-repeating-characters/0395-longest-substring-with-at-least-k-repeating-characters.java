class Solution {
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }

    private int divideAndConquer(String s, int start, int end, int k) {
        // If substring length is smaller than k
        if (end - start < k) {
            return 0;
        }

        int[] freq = new int[26];

        // Count frequency of characters
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find invalid character
        for (int mid = start; mid < end; mid++) {
            if (freq[s.charAt(mid) - 'a'] < k) {

                int midNext = mid + 1;

                // Skip consecutive invalid characters
                while (midNext < end && freq[s.charAt(midNext) - 'a'] < k) {
                    midNext++;
                }

                // Divide into left and right parts
                return Math.max(
                    divideAndConquer(s, start, mid, k),
                    divideAndConquer(s, midNext, end, k)
                );
            }
        }

        // Entire substring is valid
        return end - start;
    }
}
