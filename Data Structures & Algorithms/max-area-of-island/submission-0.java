class Solution {
    private static final int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int island = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    island = Math.max(island, dfs(grid, r, c));
                }
            }
        }
        return island;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;
        int res = 1;
        for(int[] dir : directions){
            res += dfs(grid, r + dir[0], c + dir[1]);
        }

        return res;
    }
}
