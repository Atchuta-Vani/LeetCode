/**
4 variables for 4 edges. top , bottom, left , right.
while top <= bottom and left <= right 

    move left to righ, increment top
    move top to bottom, decrement right
    move right to left, decrement bottom
    move bottom to top, increment left

    keep adding it to results.

return results.
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

/*        [0] [0 - m-1]
        [1- n-1][m-1]
        [n-1][m-2 - 0]
        [n-1 - 1] [0]
*/

    int top = 0;
    int bottom = matrix.length-1;
    int left = 0;
    int right = matrix[0].length-1;

    List<Integer> result = new ArrayList<Integer>();
    while(top<=bottom && left<= right){
        //System.out.println("left "+left+" right "+right+" top "+top+" bottom "+bottom);
        for(int i = left;i<=right;i++){
            result.add(matrix[top][i]);
        }
        top++;
        for(int j = top;j<=bottom; j++){
            result.add(matrix[j][right]);
        }
        right--;

        if(top<=bottom){
            for(int i = right;i>=left;i--){
                result.add(matrix[bottom][i]);
            }
        }
        bottom--;
        if(left<=right){
            for(int j = bottom;j>=top;j--){
                result.add(matrix[j][left]);
            }
        }
        left++;
        //System.out.println("result "+result);
    }
    return result;

    }
}
