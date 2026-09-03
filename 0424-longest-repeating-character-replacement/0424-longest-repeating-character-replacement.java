class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Current character ki frequency badhao
            int index = s.charAt(right) - 'A';
            freq[index]++;

            // Maximum frequency update karo
            maxFreq = Math.max(maxFreq, freq[index]);

            // Window size - most frequent character
            // = required replacements
            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}