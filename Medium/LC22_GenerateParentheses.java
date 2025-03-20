
//22. Generate Parentheses
//backtrack
//O(2 power 2n)


class Solution {
    List<String> result = new ArrayList();

    public List<String> generateParenthesis(int n) {
        backtrack(0,0,"",n);
        return result;
    }
    void backtrack(int open, int close, String curString,int n){
        if(curString.length() == 2*n){
            result.add(curString);
        }
        if(open<n){
            backtrack(open+1,close,curString+"(",n);
        }
        if(close<open){
            backtrack(open,close+1,curString+")",n);
        }
    }
}
