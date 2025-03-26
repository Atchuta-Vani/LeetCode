//463. Island Perimeter
//if neighbors are water or out of bounds, increment perimeter.

class Solution {

    public int islandPerimeter(int[][] grid) {
            int perimeter = 0;

        int[][] nbrs= {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    for(int k = 0;k<nbrs.length;k++){
                        int[] nbr = nbrs[k];
                        int newR = i+nbr[0];
                        int newC = j+nbr[1];
                         if(newR<0||newR>=grid.length || newC<0 || newC>=grid[0].length || grid[newR][newC] == 0){
                            perimeter++;
                         }
                    }
                }
            }
        }
    return perimeter;    
    }

    
}
