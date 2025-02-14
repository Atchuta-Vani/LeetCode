//Valid anagram
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (Character ch1 : s.toCharArray()){
            map.put(ch1,map.getOrDefault(ch1,0)+1);
        }
        for (Character ch2 : t.toCharArray()){
            if(map.containsKey(ch2)){
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2)==0){
                    map.remove(ch2);
                }

            }else{
                return false;
            }
        }
        return map.isEmpty()?true:false;
    }
}
