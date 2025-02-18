//Valid Paranthesis
//Push it to stack for open brackets and pop it when you see closing brackets.
//Time Complexity is O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            if(ch == ')' || ch ==']' || ch == '}'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char ch2 = stack.pop();
                    if(ch == ')' && ch2 != '(' ||
                        ch == ']' && ch2 != '['||
                        ch == '}' && ch2 != '{'){
                            return false;
                    }
                }

                
               }
        }
        return stack.isEmpty()? true:false;
    }
}
