/**
Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
*/

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int total =0;
        boolean isOdd = false;
        for(char ch: s.toCharArray()){
        map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int count:map.values()){
            if(count%2 == 0){
                total += count;
            }else{
                total += count -1;
                isOdd = true;
            }
        }
        if(isOdd){
            total+=1;
        }
       return total; 
    }
}

// Optimized Solution
//Use Integer Array for frequency counting.
/*
public class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];  // Assuming ASCII characters
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        int length = 0;
        boolean hasOddFrequency = false;
        
        // Iterate over the frequency array to calculate the length of the palindrome
        for (int count : freq) {
            if (count % 2 == 0) {
                length += count;  // Add even counts completely
            } else {
                length += count - 1;  // Add the largest even number (count - 1)
                hasOddFrequency = true;  // There is at least one character with an odd count
            }
        }
        
        // If there was any character with an odd count, we can place one in the center
        if (hasOddFrequency) {
            length += 1;
        }
        
        return length;
    }
}

*/
