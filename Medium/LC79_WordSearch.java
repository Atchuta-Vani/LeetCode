//LC 79 - word search in m x n array.
//use DFS with back tracking.
//TC - O(m*4 to the power n).
//SC - O(n)
class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        if(word.isEmpty()){
            return true;
        }
        for(int i = 0;i< board.length;i++){
            for(int j = 0; j< board[0].length;j++){
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
        
    }
    boolean dfs(char[][] board, String word, int r, int c, int index){
        if(index == word.length()){
            return true;
        }
        if(r<0 || r >= board.length || c <0 || c >= board[0].length || board[r][c] != word.charAt(index) || visited[r][c]){
            return false;
        }
        visited[r][c] = true;
        boolean res = dfs(board, word, r, c+1, index+1) || 
                      dfs(board, word, r, c-1, index+1) || 
                      dfs(board, word, r-1, c, index+1) || 
                      dfs(board, word, r+1, c, index+1); //if there is letter found in any of the neighbors, return true;
        visited[r][c] = false; //remove visited this is back tracking.
        return res;
    }
}
