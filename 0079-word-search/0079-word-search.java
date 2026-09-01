class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        // Try every cell as a starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                         int row, int col, int index) {

        // Word is completely found
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Store current character
        char temp = board[row][col];

        // Mark cell as visited
        board[row][col] = '#';

        // Check all 4 directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1) || // Up
                dfs(board, word, row + 1, col, index + 1) || // Down
                dfs(board, word, row, col - 1, index + 1) || // Left
                dfs(board, word, row, col + 1, index + 1);   // Right

        // Backtrack: restore original character
        board[row][col] = temp;

        return found;
    }
}