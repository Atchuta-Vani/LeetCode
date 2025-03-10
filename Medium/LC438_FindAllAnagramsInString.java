/**
438. Find All Anagrams in a String
Technique : Sliding Window.
use freq count for characters in p string.

 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null || p==null || p.length() > s.length())
            return result;
        Map<Character, Integer> freqMap = new HashMap<Character,Integer>();
        Map<Character, Integer> sfreqMap = new HashMap<Character,Integer>();
        for(Character ch: p.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
       
        int left = 0;
        int right = p.length()-1;
        String subString = s.substring(left,right);
        sfreqMap = getCharCount(subString);
        while(left<=s.length()-p.length() && right< s.length()){ // while navigating on s string
            char  ch = s.charAt(right); 
            sfreqMap.put(ch,sfreqMap.getOrDefault(ch,0)+1);//add right character to freq map

            if(freqMap.equals(sfreqMap)){
                result.add(left);
            }
            char leftChar = s.charAt(left);
            sfreqMap.put(leftChar,sfreqMap.getOrDefault(leftChar,0)-1);//remove left char from map
            if(sfreqMap.get(leftChar)==0){ //THIS is  must otherwise map will have characters with empty count 
                sfreqMap.remove(leftChar);
            }
            left++;
            right++;
        }
        return result;
    }

public Map<Character, Integer> getCharCount(String sub){
        Map<Character, Integer> freqMap = new HashMap<Character,Integer>();
        for(Character ch: sub.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        return freqMap; 
    }

}
