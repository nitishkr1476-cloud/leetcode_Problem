class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] freq = new int[26];

        // Count total frequency of each character
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        // Try for every character
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int left = 0;
            int countDiff = 0;

            for (int right = 0; right < n; right++) {

                if (text.charAt(right) != ch) {
                    countDiff++;
                }

                // Window can contain at most one different character
                while (countDiff > 1) {
                    if (text.charAt(left) != ch) {
                        countDiff--;
                    }
                    left++;
                }

                // Length cannot exceed total occurrences of ch
                ans = Math.max(ans, Math.min(right - left + 1, freq[ch - 'a']));
            }
        }

        return ans;
    }
}
