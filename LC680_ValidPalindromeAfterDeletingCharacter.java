/**
680 You’re given a string s, and you need to determine if it can become a palindrome after deleting at most one character.

Use two pointers: one at the start (left) and one at the end (right).

Compare characters at both ends:

If they match, move both pointers inward.

If they don’t match:

You have one chance to delete a character — so try both options:
Skip the left character: isPalindrome(s, left + 1, right)
Skip the right character: isPalindrome(s, left, right - 1)
If either results in a valid palindrome, return true.
If you reach the middle without needing to delete, it's already a palindrome.

 */
class Solution {
    public boolean validPalindrome(String s) {
        if(s == null)
            return true;
        int left = 0;
        int right = s.length()-1;
        int count = 0;
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left+1,right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
            
        }
        
        return true;

    }
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
