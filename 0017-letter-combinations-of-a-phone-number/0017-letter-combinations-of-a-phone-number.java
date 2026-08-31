import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, phone, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int index, String digits, String[] phone,
                           StringBuilder current, List<String> result) {

        // If we have used all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char ch : letters.toCharArray()) {
            current.append(ch);

            // Move to next digit
            backtrack(index + 1, digits, phone, current, result);

            // Remove last character (backtracking)
            current.deleteCharAt(current.length() - 1);
        }
    }
}