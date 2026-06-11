class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] steps = { n, m - 1}; 
        // dfs(m,n,0,-1,0,1,matrix,res);

        int r = 0, c = -1, d = 0;
        while(steps[d % 2] > 0){
            for(int i = 0; i < steps[d % 2]; i++){
                r += directions[d][0];
                c += directions[d][1];
                res.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d + 1) % 4;
        }

        return res;
    }

    // private void dfs(int row, int col, int r, int c, int dr, int dc, int[][] matrix, List<Integer> res){
    //     if(row == 0 || col == 0) return;

    //     for(int i = 0; i < col; i++){
    //         r += dr;
    //         c += dc;
    //         res.add(matrix[r][c]);
    //     }

    //     dfs(col, row - 1, r, c, dc, -dr, matrix, res);
    // }
}
