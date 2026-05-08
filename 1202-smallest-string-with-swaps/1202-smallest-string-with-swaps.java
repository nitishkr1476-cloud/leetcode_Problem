import java.util.*;

class Solution {

    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();
        parent = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union all pairs
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        // Group indices by connected component
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);

            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }

        char[] result = s.toCharArray();

        // Sort characters within each component
        for (List<Integer> indices : groups.values()) {

            List<Character> chars = new ArrayList<>();

            for (int idx : indices) {
                chars.add(s.charAt(idx));
            }

            Collections.sort(indices);
            Collections.sort(chars);

            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = chars.get(i);
            }
        }

        return new String(result);
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[py] = px;
        }
    }
}
