class Solution {
    public String longestPrefix(String s) {
        int n = s.length();

        // LPS = Longest Prefix which is also Suffix
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // lps[n - 1] gives the longest happy prefix length
        return s.substring(0, lps[n - 1]);
    }
}