/**
49 . Group Anagrams
Sort the strings and push it to HashMap. 
Approach 1: Sorting Strings (Using HashMap)

Intuition
Anagrams have the same characters in the same frequency.
Sorting an anagram results in the same key.

Use a HashMap:
Key: Sorted word.
Value: List of words that match the sorted key.

Algorithm
Create a HashMap → Key = sorted word, Value = List of anagrams.
Iterate through words:
Sort each word.
Use sorted word as key.
Add original word to the list.
Return the grouped lists.

Time Complexity
O(n * k log k) → k log k for sorting each word, n words.
O(nk) Space Complexity → Storing all words.

O() = n * klog(k) , k is each string size.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String,List<String>> map = new HashMap();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            //map.put(sortedString, map.getOrDefault(sortedString, new ArrayList()).add(str));
            map.putIfAbsent(sortedString,new ArrayList());
            List<String> values = map.get(sortedString);
            values.add(str);
            map.put(sortedString,values);
        }
        return new ArrayList(map.values());
    }
}
