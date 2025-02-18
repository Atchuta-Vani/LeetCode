/**
*733. Flood Fill
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];
        if(oldColor != color){
            dfs(image, sr, sc, color, oldColor);
        }
        return image;
        
    }
    void dfs(int[][] image, int row, int col, int color, int oldColor) {
        if(row < 0 || row > image.length -1 || col < 0 || col > image[0].length -1 || image[row][col] != oldColor ){
            return ;
        }
        //change color of cell 
        image[row][col] = color;

        //getChildren
        dfs(image, row-1,col, color, oldColor);
        dfs(image, row+1,col, color, oldColor);
        dfs(image, row,col-1, color, oldColor);
        dfs(image, row,col+1, color, oldColor);

    }

}
