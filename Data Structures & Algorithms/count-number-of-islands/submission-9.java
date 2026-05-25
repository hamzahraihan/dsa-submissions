class Solution {
    private final static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
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
        // initialize queue for traversing grid
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        // mark grid with 0 as visited
        grid[r][c] = '0';
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            for(int[] dir : directions){
                int nr = row + dir[0], nc = col + dir[1];
                // find boundary, if its not out of the bound we continue to process the bfs
                if(nr >= 0 && nr < grid.length &&
                     nc >= 0 && nc < grid[0].length &&
                     grid[nr][nc] == '1'){
                        q.offer(new int[] {nr,nc});
                        grid[nr][nc] = '0';
                }
            }
        }
    }
}
