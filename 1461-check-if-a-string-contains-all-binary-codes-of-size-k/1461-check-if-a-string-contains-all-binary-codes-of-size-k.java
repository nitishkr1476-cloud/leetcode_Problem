class Solution {
    public boolean hasAllCodes(String s, int k) {

        if (s.length() < k) {
            return false;
        }

        int total = 1 << k;
        boolean[] seen = new boolean[total];

        int num = 0;

        // First window
        for (int i = 0; i < k; i++) {
            num = (num << 1) | (s.charAt(i) - '0');
        }

        seen[num] = true;
        int count = 1;

        // Remaining windows
        int mask = total - 1;

        for (int i = k; i < s.length(); i++) {

            num = ((num << 1) & mask) | (s.charAt(i) - '0');

            if (!seen[num]) {
                seen[num] = true;
                count++;
            }

            if (count == total) {
                return true;
            }
        }

        return count == total;
    }
}