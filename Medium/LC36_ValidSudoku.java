class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> validSet = new HashSet(Arrays.asList('1','2','3','4','5','6','7','8','9','.'));
        int ROWS = board.length;
        int COLS = board[0].length;

        List<Set<Character>> boxSet = new ArrayList<>(9);
        for(int i = 0;i<9;i++){        
            boxSet.add(new HashSet());        
        }
        int offset = -2;

        for(int i = 0;i<ROWS;i++){
            if(i%3 == 0) offset += 2;

            Set<Character> rowsSet = new HashSet();
            for(int j = 0;j<COLS;j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                int boxIndex = i/3 + j/3 + offset;   
                if(!validSet.contains(ch) || rowsSet.add(ch) == false){
                    return false;
                }
                if(!validSet.contains(ch) || boxSet.get(boxIndex).add(ch) == false){
                    return false;
                }
            }
        }

        for(int j = 0;j<COLS;j++){
            Set<Character> colsSet = new HashSet();
            for(int i = 0;i<ROWS;i++){
                char ch = board[i][j];
                if(ch == '.') continue;
                if(!validSet.contains(ch) || colsSet.add(ch) == false){
                    return false;
                }
            }
        }
        
     return true;   
    }
}
