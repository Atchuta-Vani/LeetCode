
//205. Isomorphic Strings
/**

TWO Hashmaps for saving the mapping.
Approach
We can solve this by using two hash maps:

One for mapping characters from the first string to the second.

Another for mapping characters from the second string to the first.

Steps:
Check lengths: If the strings are not of the same length, they cannot be isomorphic, so return false.

Character mapping: For each character in both strings:

Check if it has already been mapped to a character in the other string.

If not, map it and ensure the reverse mapping is also valid (i.e., no two characters map to the same character).

If you find a conflict in mappings, return false.

If no conflicts are found, return true
 */
// TC: O(n)
//SC: O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> stMap = new HashMap();
        Map<Character,Character> tsMap = new HashMap();
        if(s.length() != t.length())
            return false;

        for(int i = 0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(stMap.containsKey(ch1)){
                if(stMap.get(ch1) != ch2)
                    return false;
            }else{
                stMap.put(ch1,ch2);
            }

            if(tsMap.containsKey(ch2)){
                if(tsMap.get(ch2) != ch1)
                    return false;
            }else{
                tsMap.put(ch2,ch1);
            }
        }

    return true;
    }
}
