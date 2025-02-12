class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> magazineMap = new HashMap<Character, Integer>();
    for(char ch : magazine.toCharArray()){
    if(magazineMap.containsKey(ch)){
        magazineMap.put(ch,magazineMap.get(ch) + 1);
    }else
         magazineMap.put(ch,1);
    }
    for(char ch:ransomNote.toCharArray()){
        if(magazineMap.containsKey(ch)){
            magazineMap.put(ch,magazineMap.get(ch) - 1);
        }else{
        return false;
        }
        if(magazineMap.get(ch)==0){
            magazineMap.remove(ch);
        }
    }
    return true;
    }
}
