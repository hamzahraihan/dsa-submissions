class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> atlq = new LinkedList<>();

        for(int c = 0; c < cols; c++){
            pacq.offer(new int[]{0, c});
            atlq.offer(new int[]{rows - 1, c});
        }

        for(int r = 0; r < rows; r++){
            pacq.offer(new int[]{r, 0});
            atlq.offer(new int[]{r, cols - 1});
        }

        bfs(heights, pacq, pac);
        bfs(heights, atlq, atl);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] ocean){
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];
            ocean[row][col] = true;
            for(int[] dir : directions){
                int nr = row + dir[0], nc = col + dir[1];
                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]){
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
