class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        int[] need = new int[128]; // ASCII
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        
        int left = 0, right = 0;
        int required = t.length(); // total chars needed
        
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            char rChar = s.charAt(right);
            
            // If this char is needed, decrease required
            if (need[rChar] > 0) {
                required--;
            }
            need[rChar]--;
            right++;
            
            // When we have a valid window
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                char lChar = s.charAt(left);
                need[lChar]++;
                
                // If removing breaks requirement
                if (need[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
