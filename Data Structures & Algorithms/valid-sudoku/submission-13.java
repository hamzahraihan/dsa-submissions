class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '.') continue;
                String key = (r / 3) + "," + (c / 3);
                if( cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) || 
                    boxes.computeIfAbsent(key, k -> new HashSet<>()).contains(board[r][c])
                ) {
                    return false;
                }

                cols.get(c).add(board[r][c]);
                rows.get(r).add(board[r][c]);
                boxes.get(key).add(board[r][c]);
            }
        }

        return true;
    }
}
