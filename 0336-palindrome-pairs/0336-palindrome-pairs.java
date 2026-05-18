class Solution {
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        // Store word with index
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            
            String word = words[i];
            
            for (int j = 0; j <= word.length(); j++) {
                
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                // Case 1
                if (isPalindrome(left)) {
                    
                    String revRight = new StringBuilder(right).reverse().toString();
                    
                    if (map.containsKey(revRight) && map.get(revRight) != i) {
                        ans.add(Arrays.asList(map.get(revRight), i));
                    }
                }
                
                // Case 2
                if (right.length() > 0 && isPalindrome(right)) {
                    
                    String revLeft = new StringBuilder(left).reverse().toString();
                    
                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        ans.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }
        
        return ans;
    }
    
    // Check palindrome
    private boolean isPalindrome(String s) {
        
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            
            l++;
            r--;
        }
        
        return true;
    }
}
