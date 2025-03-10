/*class Solution {
    public String longestPalindrome(String s) {
        int left=0, right =0, maxlength = 0;
        String subString = "";
        for(right = 0; right<s.length(); right++){
             subString = s.substring(left,right+1);
            if(isPalindrome(subString)){

            }

        }
        return subString;
    }


    boolean isPalindrome(String str){
        int i = 0, j = str.length()-1;
        for(i=0;i<str.length()/2;i++){
            if(str.charAt(i) == str.charAt(j)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}*/

/**
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.
Approach:expand from center.
 */

class Solution {
    public int maxlength = Integer.MIN_VALUE;
    String result =  null;

    public String longestPalindrome(String s) {
        int count = 0;
        String maxString="";
        for(int i =0;i<s.length();i++){
            String s1 = expandFromCenter(s,i,i);
            String s2 = expandFromCenter(s,i,i+1);
            
            if(maxlength < s1.length()){
                maxlength = s1.length();
                result = s1;
            }

            if(maxlength < s2.length()){
                maxlength = s2.length();
                result = s2;
            }        
            
            }
        return result;
        
    }
    String expandFromCenter(String s, int left, int right){
        int count = 0;
        while(left >=0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            count++;

            if(maxlength < right-left+1){
                maxlength = Math.max(maxlength, right-left+1);
                result = s.substring(left,right+1);
            }
            left--;
            right++;
            

        }
    return result;
    }
}
