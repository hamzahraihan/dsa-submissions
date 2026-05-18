class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(dfs(board, 0, r, c,word, new boolean[board.length][board[0].length])){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int r, int c,String word, boolean[][] visited){
        if(i >= word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || word.charAt(i) != board[r][c]){
            return false;
        }

        visited[r][c] = true;
        for(int[] dir : directions){
            if(dfs(board, i + 1, r + dir[0], c + dir[1], word,visited)){
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
