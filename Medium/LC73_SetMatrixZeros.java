/**
 Approach (In-place, O(1) Space)
Check if first row and first column need to be zeroed.

Use first row and column as markers to mark rows/cols that need to be zeroed.

Update inner matrix based on markers.

Zero first row and column if needed.

 */
class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int i =0;i<m;i++){
            if(matrix[i][0] == 0)
                firstColZero = true;
        }

        for(int j = 0;j<n;j++){
            if(matrix[0][j] == 0)
                firstRowZero = true; 
        }

        for(int i = 1;i<m;i++)//Important to run it from 1.
            for(int j=1;j<n;j++)
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

        for(int i = 1;i<m;i++) //important to run it from 1 . otherwise first row and col will be overriden.
            for(int j=1;j<n;j++)
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] =0;

        if(firstRowZero)
            for(int j = 0;j<n;j++){
                matrix[0][j] =0;
            }              
        if(firstColZero)
            for(int i = 0;i<m;i++){
                matrix[i][0] =0;
            }                          
    }
}
