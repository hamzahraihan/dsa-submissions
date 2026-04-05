class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '.') continue;
                if(!seen.add(stringify("row",r, board[r][c])) ||
                   !seen.add(stringify("col",c, board[r][c]))||
                   !seen.add(stringify("sub-box",r/3,c/3, board[r][c]))){
                    return false;
                }
            }
        }
        return true;
    }
    private String stringify(String cell, int pos, char ch){
        return new StringBuilder(cell)
        .append(pos)
        .append('#')
        .append(ch)
        .toString();

    }

    private String stringify(String box,int r,int c, char ch){
        return new StringBuilder(box)
        .append(r)
        .append(c)
        .append('#')
        .append(ch)
        .toString();

    }
}
