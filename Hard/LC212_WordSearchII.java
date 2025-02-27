class Solution {
    Set<String> result = new HashSet();
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isWord = false;
         public void insertWord(String word){
            TrieNode cur = this;
            for(char c: word.toCharArray()){
                 cur.children.putIfAbsent(c,new TrieNode());
                 cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }
    

       
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word:words){
            root.insertWord(word);
        }
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for(int i=0;i<ROWS;i++){
            for(int j = 0;j< COLS;j++){
                dfs(board,i,j,root,"",visited);
            }
        }

        return new ArrayList<String>(result);
        
    }

    void dfs(char[][] board,int r, int c, TrieNode node,String word, boolean[][] visited){

        if(r<0 || r>= board.length || c<0|| c>=board[0].length || visited[r][c] || !node.children.containsKey(board[r][c])){
            return;
        }

        visited[r][c] = true;
        word += board[r][c];
        node = node.children.get(board[r][c]);
        if(node.isWord){
            result.add(word);
        }

        dfs(board, r,c+1,node, word, visited);
        dfs(board, r,c-1,node, word, visited);        
        dfs(board, r-1,c,node, word, visited);
        dfs(board, r+1,c,node, word, visited);

        visited[r][c] = false;


    }

}
