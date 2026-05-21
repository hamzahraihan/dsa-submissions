class Solution {
    private final static int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};
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

        bfs(pacq, pac, heights);
        bfs(atlq, atl, heights);

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

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for(int[] d : directions){
                int nr = r + d[0], nc = c + d[1];
                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !ocean[nr][nc] &&
                heights[nr][nc] >= heights[r][c]){
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
