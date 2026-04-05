class Solution {
    private static int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(dfs(row,col,0,board,word)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, int index, char[][] board, String word){
        if(index >= word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(index)) return false;

        char ch = board[row][col];
        board[row][col] = '#';

        for(int[] d : this.direction){
            if(dfs(row + d[0],  col + d[1],  index + 1, board, word)) return true;
        }
        board[row][col] = ch;
        return false;
    }

}
