//415 add two strings, which has numbers in them.
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        int sum = 0;
        int carry = 0;
        char[] number1 = num1.toCharArray();
        char[] number2 = num2.toCharArray();
        int i = number1.length-1;
        int j = number2.length-1;
        while(i>=0 || j >=0){
            
            if(i>=0){
                int d1 = number1[i]-'0';
                sum += d1;
                i--;
            }
            if(j>=0){
                 int d2 = number2[j] - '0';
                sum += d2;
                j--;
            }
            
           
            sum = sum;
            carry = sum/10;
            sum = sum%10;
            result.append(sum);
            sum = carry;
        }
        if(carry == 1){
            result.append(carry);
        }
        //System.out.println(result);
        
        return result.reverse().toString();
    }
}
