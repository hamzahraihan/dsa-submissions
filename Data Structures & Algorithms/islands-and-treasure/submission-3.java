class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }
        if(q.size() == 0) return;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= grid.length || nc >= grid[0].length || nr < 0 || nc < 0 || grid[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{nr, nc});
                grid[nr][nc] = 1 + grid[row][col];
            }
        }
    }
}
