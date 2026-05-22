class Solution {
    private final static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> atlq = new LinkedList<>();

        for(int c = 0; c < COLS; c++){
            pacq.offer(new int[]{0, c});
            atlq.offer(new int[]{ROWS - 1, c});
        }

        for(int r = 0; r < ROWS; r++){
            pacq.offer(new int[]{r, 0});
            atlq.offer(new int[]{r, COLS - 1});
        }

        bfs(pacq, pac, heights);
        bfs(atlq, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            ocean[r][c] = true;
            for(int[] d : directions){
                int nr = r + d[0], nc = c + d[1];
                if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
