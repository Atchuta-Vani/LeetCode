// get freq map
//iterate on for loop and for each character and its subsequent character, check if the key == value in map and character is not equal to next character.

class Solution {
    public String findValidPair(String s) {

        Map<Character, Integer> freqMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        //System.out.println(freqMap);
        for(int i = 0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2;
            if(i<s.length()-1){
                ch2 = s.charAt(i+1);
                if(ch1 != ch2 && freqMap.get(ch1) == (ch1-'0') && freqMap.get(ch2) == (ch2-'0')){
                    sb.append(ch1);
                    sb.append(ch2);
                    break;
                }   
            }
                             
        }
    return sb.toString();    
    }
}
