class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int i) {
        if (i >= word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#'
            || board[r][c] != word.charAt(i)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        for (int[] dir : directions) {
            if (dfs(board, r + dir[0], c + dir[1], word, i + 1)) {
                return true;
            }
        }

        board[r][c] = temp;
        return false;
    }
}
