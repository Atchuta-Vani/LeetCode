//LC 211 Dictionary, add word, search word. wild character search with .
//TC - O(n)
//SC - O(t+n)
//Input: ["WordDictionary", "addWord", "day", "addWord", "bay", "addWord", "may", "search", "say", "search", "day", "search", ".ay", "search", "b.."]
//OP: [null, null, null, null, false, true, true, true]

class WordDictionary {
    TrieNode root;
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isWord = false;
    }
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = this.root;
        for(char ch:word.toCharArray()){
            cur.children.putIfAbsent(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word,0,this.root);
    }
    public boolean dfs(String word, int j,TrieNode root){
        TrieNode cur = root;
        for(int i = j;i< word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){//wild character. iterate on every child. 
                for(TrieNode child: cur.children.values()){
                    if(child != null && dfs(word,i+1,child)){
                        return true;//if word is found atleast once, return true.
                    }
                }
            return false;//if entire dfs is done with out finding word, return false. 
            }else{//character is not ".", then look for that character in children. if it doesnot exist return false . if it does, move to next level
                if(!cur.children.containsKey(ch)){
                   return false;
                }
                 cur = cur.children.get(ch);//move to one level below.
            }
        }
        return cur.isWord;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
