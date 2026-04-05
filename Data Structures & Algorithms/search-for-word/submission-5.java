class Solution {
    public boolean exist(char[][] board, String word) {
        // travels up, down, left, right
        int[][] directions = { {-1,0},{1,0},{0,-1},{0,1}};
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(wordFinder(r,c,0,visited,board,word,directions)) return true;
            }
        }
        return false;
    }

    private boolean wordFinder(int r, int c, int index,Set<Pair<Integer,Integer>> visited, char[][] board, String word,int[][] directions){
        if(index >= word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length  || visited.contains(new Pair<>(r,c)) || board[r][c] != word.charAt(index) ){
            return false;
        }

        visited.add(new Pair<>(r,c));
        for(int[] dir : directions ){
            if(wordFinder(r + dir[0], c + dir[1], index + 1, visited, board, word, directions) )return true;
        }
        visited.remove(new Pair<>(r,c));
        
        return false;
    }
}
