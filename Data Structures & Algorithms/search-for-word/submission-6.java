class Solution {
    private final int[][] direction = {{0,1}, {0,-1}, {1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(wordFinder(r,c,0,visited,board,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordFinder(int r, int c, int i, boolean[][] visited, char[][] board, String word){
        if(i == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(i)) return false;

        visited[r][c] = true;

        for(int[] dir : direction){
            if(wordFinder(r + dir[0], c + dir[1], i + 1, visited, board, word)){
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}
