class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuffer res = new StringBuffer("");
        int a1=0;
        int b1=0;
    while ( i >=0 | j >=0){
        int sum = carry;
        if(i>=0){
            a1 = a.charAt(i)-'0'; //11
            //System.out.println("i "+i+"a1 "+a1);
            sum += a1;
            i--;
        }
       if(j>=0){
            b1 = b.charAt(j)-'0'; // 1
            //System.out.println("j "+j+"b1 "+b1);
            sum += b1;
            j--;
       }
        carry = sum/2;
        //System.out.println("Sum "+sum+"carry = "+carry+"digit = "+sum%2);
        res.append(sum%2);
    }    
    if(carry == 1){
         res.append(carry);
    }
   // System.out.println(res);    
    return res.reverse().toString();
    }
}
/**
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/
