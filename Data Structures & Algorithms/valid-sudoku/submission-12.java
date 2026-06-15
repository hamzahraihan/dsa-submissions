class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '.') continue;
                String squareKey = (r / 3) + "." + (c / 3);
                if(row.computeIfAbsent(r, key -> new HashSet<>()).contains(board[r][c]) || 
                    col.computeIfAbsent(c, key -> new HashSet<>()).contains(board[r][c]) ||
                    box.computeIfAbsent(squareKey, key -> new HashSet<>()).contains(board[r][c]) ){
                        return false;
                    }
                row.get(r).add(board[r][c]);
                col.get(c).add(board[r][c]);
                box.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}
