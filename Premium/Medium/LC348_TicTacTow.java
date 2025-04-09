/**
Instead of storing the entire board (which would be O(n²)),
just track the counts:

rows[i] → sum of marks on row i
cols[j] → sum of marks on column j
diagonal
antiDiagonal
If a player plays:
Player 1 → add +1
Player 2 → add -1

Then:
If any rows[i] == n → Player 1 wins
If any rows[i] == -n → Player 2 wins
(Same for columns, diagonals)

✅ O(1) per move — very efficient!
*/

package LC;

public class LC348_TicTacToe {
        int[] rowSum;
        int[] colSum;
        int diagonal;
        int antiDiagonal;
        int n;

        public LC348_TicTacToe(int n) {
            rowSum = new int[n];
            colSum = new int[n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            int num2Add = (player == 1)? 1: -1;
            rowSum[row] += num2Add;
            colSum[col] += num2Add;
            if(row == col){
                diagonal += num2Add;
            }
            if(row+col == n-1){
                antiDiagonal += num2Add;
            }
            if(Math.abs(rowSum[row]) == n|| Math.abs(colSum[col]) == n || diagonal == n || antiDiagonal == n)
                return player;
        return 0;
        }

}
