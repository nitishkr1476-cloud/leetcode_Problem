
import java.util.*;

class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // If current character is an operator
            if (ch == '+' || ch == '-' || ch == '*') {

                // Left part
                String left = expression.substring(0, i);

                // Right part
                String right = expression.substring(i + 1);

                // All possible results from left and right
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                // Combine every possible left result
                // with every possible right result
                for (int a : leftResults) {
                    for (int b : rightResults) {

                        if (ch == '+') {
                            result.add(a + b);
                        } 
                        else if (ch == '-') {
                            result.add(a - b);
                        } 
                        else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }

        // If there was no operator, expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}

