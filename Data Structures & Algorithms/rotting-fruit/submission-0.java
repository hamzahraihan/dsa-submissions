class Solution {
    private int[][] directions = {{1,0},{0,-1},{-1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        // indicate how many fresh banana left
        int fresh = 0;
        // indicate how much time needed to rotten all fresh bananas
        int time = 0;
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1) {
                    fresh++;
                }
                // we start with the rotten banana
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }

        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1]; 

                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        // rot the fresh banana
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            // added time after we rot the current fresh banana
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
