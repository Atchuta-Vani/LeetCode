//76. Minimum Window Substring
/**
"Prepare frequency count of t:

Create a map (tFreqCount) to count how many times each character appears in string t.

Set up sliding window:

Use two pointers l and r to define the current window in string s.

Create another map (windowFreqCount) to track the count of characters in the current window.

Track how many required characters we ""have"":

need = number of unique characters in t.

have = number of characters that meet the required count in the current window.

Expand the window (move r from left to right):

For each character at position r in s:

Add it to windowFreqCount.

If this character is in t and its count in the window matches the required count, increment have.

Try to shrink the window (while it still satisfies the condition):

While have == need (i.e., the current window has all required characters):

Check if the current window is smaller than the previous minimum. If so, update the result.

Then try to shrink the window from the left (l):

Decrease the count of the character at s[l] in windowFreqCount.

If this character is in t and its count in the window is now less than what's required in t, decrement have.

Move the left pointer l to the right.

Continue expanding and shrinking the window until the end of the string is reached.

Return the result:

If a valid window was found, return the substring between the saved indices.

If no valid window exists, return an empty string."

TC O(s.length + t.length)
SC O(m) -  m is unique characters in s and t
 */

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || t.length() >s.length()){
            return "";
        }
            
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();
        for(char ch: t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }

        int left = 0;
        int right = 0;
        
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        int formed = 0;
        int required = tmap.size();
        
        for(right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            //need to use equals here. == is not working for larger int values.
            if(tmap.containsKey(ch) && smap.get(ch).equals(tmap.get(ch))){
                formed++;
            }


            while (formed == required){
                if(right-left+1<minLength){
                    minLength = right-left+1;                    
                    minLeft = left;
                }

                char lc = s.charAt(left);
                smap.put(lc, smap.get(lc) - 1);
                if(tmap.containsKey(lc) && smap.get(lc) < tmap.get(lc)){
                    formed--;
                }
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE)? "": s.substring(minLeft,minLeft+minLength);
    }
}
