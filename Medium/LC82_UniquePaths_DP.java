/*
Approach 1: DP with 2D Array
Create a dp 2D array of size m x n.
Initialize:
First row = 1 (only move right).
First column = 1 (only move down).
Fill the rest using:
dp[i][j] = dp[i-1][j] + dp[i][j-1];
Return dp[m-1][n-1].
*/
// 62. Unique Paths
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = 1;
        }

        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
    return dp[m-1][n-1];             
    }

}
