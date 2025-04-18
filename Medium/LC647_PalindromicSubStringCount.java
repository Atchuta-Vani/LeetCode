/**
647. Palindromic Substrings count;
Given a string s, return the number of palindromic substrings in it.
Approach:expand from center.
 */

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i =0;i<s.length();i++){
            count += expandFromCenter(s,i,i);
            count += expandFromCenter(s,i,i+1);
        }

        return count;
        
    }
    int expandFromCenter(String s, int left, int right){
        int count = 0;
        while(left >=0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    return count;
    }
}
