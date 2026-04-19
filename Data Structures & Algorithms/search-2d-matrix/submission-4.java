class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1; // first row, last column

        // loop r within bound and c within bound;
        while(r < m && c >= 0){
            if(matrix[r][c] < target){
                r += 1;
            }else if(matrix[r][c] > target){
                c -= 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
