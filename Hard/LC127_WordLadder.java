/**
"Approach Steps:
BFS Initialization:

Treat each word as a node.
Start BFS from the start word and keep track of visited nodes to avoid cycles.
Word Transformation:

For each word, generate all possible words that differ by one character.
If a transformed word exists in the word list and has not been visited yet, add it to the BFS queue.
End Condition:

If we reach the target word, return the current transformation sequence length.
If the queue is exhausted and we don't reach the target, return 0."
 */
//127. Word Ladder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet();
        int count = 0;
        for(String word:wordList){
            wordSet.add(word);
        }
        if(!wordSet.contains(endWord) )
            return count;
        Queue<String> wordQueue = new LinkedList();
        wordQueue.offer(beginWord);
        count = 1;
        while(!wordQueue.isEmpty()){

            int size = wordQueue.size();
            for(int i = 0;i<size;i++){
                String word = wordQueue.poll();

                for(int j =0;j<word.length();j++)
                    for(char ch ='a';ch<='z';ch++){
                        if(ch == word.charAt(j)) continue;
                        String newWord = word.substring(0,j)+ch+word.substring(j+1);
                        
                        if(newWord.equals(endWord)){
                            return count+1;
                        }
                        if(wordSet.contains(newWord)){
                            wordQueue.offer(newWord);
                            wordSet.remove(newWord);
                            //System.out.println("newWord "+newWord+"count "+count);
                        }
                    }
            }
        count++;
    
        }

    return 0;
    }
}
