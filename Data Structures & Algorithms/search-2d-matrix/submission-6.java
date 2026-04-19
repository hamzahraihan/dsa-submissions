class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length; 
        int top = 0, bot = m - 1;
        while(top <= bot){
            int row = (top + bot) / 2;
            if(matrix[row][n - 1] < target){
                top = row + 1;
            } else if (matrix[row][0] > target){
                bot = row - 1;
            } else {
                break;
            }
        }

        int row = (top + bot) / 2;
        int l = 0, r = n - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(matrix[row][mid] < target){
                l = mid + 1;
            } else if (matrix[row][mid] > target){
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
