/**
150. Evaluate Reverse Polish Notation
declare stack of integers, push tokens into stack. use Integer.parseInt to convert String to Int.
if token is operand, pop two elements and evaluate. 
else push values into stack

 */

class Solution {
    public int evalRPN(String[] tokens) {

        List<String> validOps = Arrays.asList("+","-","*","/");
        Stack<String> stack = new Stack();
        for(String str: tokens){
            if(isNumeric(str)){
                stack.push(str);
                //System.out.println("stack is "+stack);
            }else if(validOps.contains(str) ){
                Integer one = Integer.parseInt(stack.pop());
                Integer two = Integer.parseInt(stack.pop());

                Integer result = new Integer(getResult(one, two, str));
                stack.push(result.toString());
                //System.out.println("stack is "+stack);
            }
        }

        if(stack.size()==1){
            return new Integer(stack.pop()).intValue();
        }else{
            return -1;
        }
        
    }

    public static boolean isNumeric(String str){

        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static int getResult(Integer one, Integer two, String str){
        int result = 0;
        switch(str){
            case "+":
                result = one + two;
                break;
            case "-":
                result = two - one;
                break;
            case "*":
                result = one * two;
                break;
            case "/":
                result = two / one ;
                //System.out.println(one + str + two+" = "+ result);            
                break;
        }
        return result;
    }
}
