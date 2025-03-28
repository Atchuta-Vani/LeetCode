//Use STack, declare pair class as character and it is count. 
/*iterate on input string, 
    if character is top pf stack, increment count
        if count = k, pop the pair from stack. 
*   else 
        push character and count as 1 to stack. 
return remaining characters in stack as string at the end. 
*/
//1209. Remove All Adjacent Duplicates in String II
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek().ch){
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }                
            }else{
                stack.push(new Pair(c,1));
            }
        }
    StringBuilder sb = new StringBuilder();    
    for(Pair p: stack){
        for(int i =0;i<p.count;i++)
            sb.append(p.ch);
    }
    return sb.toString();
    }
class Pair {
    char ch;
    int count;
    Pair(char ch, int ct){
        this.ch = ch;
        this.count = ct;
    }
}    
}
