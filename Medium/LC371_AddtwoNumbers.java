/**
We use bitwise XOR and AND + shift to simulate addition:

a ^ b gives the sum without carry.

a & b gives the carry (i.e., which bits both have set to 1), and shifting it left gives carry in the correct position for the next iteration.

Repeat this until carry becomes 0.
 */

class Solution {
    public int getSum(int a, int b) {

        int carry = 0;
        while(b!=0){
            carry = a&b; // common bits of a ,b
            a = a^b; // sum without carry
            b = carry<<1; // move carry to the left;
        }
    return a;

        //following doesnot work because a and b can be negative. 
       /* int sum = 0;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while(a>0 || b>0 || carry !=0){
            sum=carry;
            if(a>0){
                sum += a%10;
                a = a/10;
            }                
            if(b>0){
                sum+= b%10;                
                b = b/10;
            }
            carry = sum/10;
            sum = sum%10;
            sb.append(sum);
            //System.out.println("carry "+carry);
        }
        
        return Integer.parseInt(sb.reverse().toString());*/
        
    }
}
