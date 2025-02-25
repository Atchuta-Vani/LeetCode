/**
Optimal Approach: Sliding Window (O(N))
Logic:
Use a sliding window with two pointers: left and right.
Expand the window (right++) while keeping track of:
Frequency of each character.
Most frequent character count (maxFreq) inside the window.
If the number of characters to replace (window_size - maxFreq) exceeds k, shrink the window (left++).
Track the maximum window size.

 */
class Solution {
    public int characterReplacement(String s, int k) {
        int left =0,right = 0,maxFreq = 0, windowsize = 0,maxWS = 0;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(right=0;right<s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            windowsize = right - left+1;
            // imp: Update maxFreq to the highest frequency of any character in the window**
             maxFreq = Math.max(maxFreq, map.get(ch));
            if(windowsize - maxFreq >k){
                char ch2 = s.charAt(left);
                if(map.get(ch2) > 0){
                    map.put(ch2,map.get(ch2)-1);
                }
                left++;
            }
            maxWS = Math.max(maxWS,right-left+1);
        }
    return maxWS;
    }
}
