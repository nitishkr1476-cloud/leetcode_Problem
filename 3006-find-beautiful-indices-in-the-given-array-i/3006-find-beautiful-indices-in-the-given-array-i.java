import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();

        // Find all occurrences of a
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                aIndices.add(i);
            }
        }

        // Find all occurrences of b
        for (int j = 0; j <= s.length() - b.length(); j++) {
            if (s.substring(j, j + b.length()).equals(b)) {
                bIndices.add(j);
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Check every occurrence of a
        for (int i : aIndices) {

            for (int j : bIndices) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }

                // Since bIndices is sorted
                if (j > i + k) {
                    break;
                }
            }
        }

        return ans;
    }
}
