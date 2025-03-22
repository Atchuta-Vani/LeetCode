/**
387. First Unique Character in a String
 */

class Solution {
    public int firstUniqChar(String s) {

        Map<Character,Integer> freQMap = new HashMap();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freQMap.put(ch,freQMap.getOrDefault(ch,0)+1);            
        }


        for(int i=0;i<s.length();i++){
            if(freQMap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
