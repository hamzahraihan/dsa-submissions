class Solution {
    private final static int[][] directions = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0';
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];

            for(int[] dir : directions){
                int nRow = row + dir[0], nCol = col + dir[1];
                // check bounds
                // mark every island with 0 (visited) 
                if(nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == '1'){
                    q.offer(new int[]{nRow, nCol});
                    grid[nRow][nCol] = '0';
                }
            }
        }
    }
}
