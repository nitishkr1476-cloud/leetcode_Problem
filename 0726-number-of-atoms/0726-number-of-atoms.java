import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        
        int i = 0, n = formula.length();
        
        while (i < n) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } 
            else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                Map<String, Integer> top = stack.pop();
                Map<String, Integer> current = stack.peek();
                
                for (String key : top.keySet()) {
                    current.put(key, current.getOrDefault(key, 0) + top.get(key) * multiplier);
                }
            } 
            else {
                // Parse element name
                int start = i;
                i++; // uppercase letter
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(start, i);
                
                // Parse count
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                Map<String, Integer> current = stack.peek();
                current.put(element, current.getOrDefault(element, 0) + count);
            }
        }
        
        // Sort result
        Map<String, Integer> resultMap = stack.pop();
        TreeMap<String, Integer> sorted = new TreeMap<>(resultMap);
        
        StringBuilder result = new StringBuilder();
        for (String key : sorted.keySet()) {
            result.append(key);
            int count = sorted.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        
        return result.toString();
    }
}
