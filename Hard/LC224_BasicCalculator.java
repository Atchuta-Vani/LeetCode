//224. Basic Calculator
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
           
            
            if(Character.isDigit(ch)){
                number = number*10 + (ch-'0');
                //result += sign*number;
                //System.out.println("number "+number+" result "+result+"ch "+ch);
            }else if(ch == '+'){
                result += sign*number;
                sign = 1;
                number = 0;
                //System.out.println("result "+result);

            }else if(ch == '-'){
                result += sign*number;
                sign = -1;
                number = 0;
            }else if(ch == '('){
                stack.push(sign);
                stack.push(result);
                //number = 0;
                result = 0;
                sign = 1;
            }else if(ch == ')'){
                result+=sign*number;
                int stackResult = stack.pop();
                int stackSign = stack.pop();
                
                result = stackSign * result + stackResult; // THIS is Confusing.
                number = 0;
                
            }                        
        }
        if(number !=0){
            result+=sign*number;
        }
    return result;
    }
}
