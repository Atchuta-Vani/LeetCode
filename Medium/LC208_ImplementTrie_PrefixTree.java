//208. Implement Trie (Prefix Tree)
//TC: O(n) n is the length of the word
//SC: O(t) t is the tree nodes 
/*
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

*/

public class TrieNode{
    Map<Character, TrieNode> children = new HashMap();
    boolean endOfWord = false;

    }
class Trie {
TrieNode root;

    public Trie() {
         root = new TrieNode();
        root.endOfWord = true;
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(Character c:word.toCharArray()){
                cur.children.putIfAbsent(c,new TrieNode());//we can not keep null because we need to navigate to it in next step
                cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(Character c:word.toCharArray()){
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
        }
        return cur.endOfWord;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(Character c:prefix.toCharArray()){
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
