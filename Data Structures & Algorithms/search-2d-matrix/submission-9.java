class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        while(top < bottom) { 
            int row = (top + bottom) / 2;
            if(matrix[row][n - 1] < target) { 
                top = row + 1;
            } else if(matrix[row][0] > target) { 
                bottom = row - 1;
            } else { 
                break;
            }
        }

        int row = (top + bottom) / 2;
        int l = 0, r = n - 1;
        while(l <= r) { 
            int mid = (l + r) / 2;
            if(matrix[row][mid] < target) { 
                l = mid + 1;
            } else if ( matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
