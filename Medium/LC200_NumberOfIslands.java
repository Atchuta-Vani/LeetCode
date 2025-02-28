//200. Number of Islands
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//TC = O(m x n)
//SC - O(m x n)
class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int i = 0;i<ROWS;i++)
            for(int j = 0;j<COLS;j++){
                if(grid[i][j] == '1'){
                    countIslands(grid,i,j); //dfs
                    count++;
                }
                
            }
        return count;
    }
    void countIslands(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0'; //replace to 0 so that it marks this cell as visited
        countIslands(grid,i+1,j);
        countIslands(grid,i-1,j);
        countIslands(grid,i,j+1);
        countIslands(grid,i,j-1);
    }
}
