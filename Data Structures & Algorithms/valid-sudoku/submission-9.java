class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if(board[r][c] == '.') continue;
                String boxKey = (r / 3) + "." + (c / 3);
                if (rows.computeIfAbsent(r, key -> new HashSet<>()).contains(board[r][c])
                    || cols.computeIfAbsent(c, key -> new HashSet<>()).contains(board[r][c])
                    || boxes.computeIfAbsent(boxKey, key -> new HashSet<>())
                        .contains(board[r][c])) {
                    return false;
                }
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                boxes.get(boxKey).add(board[r][c]);
            }
        }

        return true;
    }
}
