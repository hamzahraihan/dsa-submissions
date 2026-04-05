class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] directions =  {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, 0, board, word, directions)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index, char[][] board, String word, int[][] directions){
        if(index >= word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) return false;

        char ch = board[row][col];
        board[row][col] = '#';
        for(int[] d : directions){
            if (dfs(row + d[0], col + d[1], index + 1, board, word, directions)) {
                return true;
            }
        }
        board[row][col] = ch;
        return false;
    }
}
