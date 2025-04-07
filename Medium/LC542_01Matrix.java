/**
Step-by-Step Approach:
Initialization:

Create a queue to store all the cells that contain 0. These cells are the starting points for BFS.

Create a distance matrix dist to store the shortest distance from each cell to the nearest 0. Initially, set the distance of each cell to infinity (Integer.MAX_VALUE), except for cells containing 0 which should have a distance of 0.

Add All 0 Cells to the Queue:

Iterate through the matrix, and for each cell that contains 0, set its distance in dist to 0, and add it to the queue.

Breadth-First Search (BFS):

Perform BFS starting from each 0 cell in the queue. For each cell, check its four neighbors (up, down, left, right).

If the neighbor hasn't been visited yet (i.e., its distance is still Integer.MAX_VALUE), update its distance and add it to the queue.

Return the Distance Matrix:

Once BFS completes, the distance matrix will contain the shortest distances from each cell to the nearest 0

 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int ROWS = mat.length;
        int COLS = mat[0].length;

        Queue<int[]> queue = new LinkedList();
        for(int i = 0;i<ROWS;i++)
            for(int j = 0; j< COLS;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        int[][] neighbors = {{1,0},{-1,0},{0,1},{0,-1}};    
        while(!queue.isEmpty()){
            int[] item = queue.poll();
            int row = item[0];
            int col = item[1];
            for(int[] n:neighbors){
                int newRow = item[0] + n[0];
                int newCol = item[1] + n[1];

                if(newRow >=0 && newRow<ROWS && newCol>=0 && newCol < COLS && mat[newRow][newCol] == -1){
                    mat[newRow][newCol] = mat[row][col] +1;
                    queue.offer(new int[]{newRow,newCol});
                }

            }
        }

    return mat;
    }
}
