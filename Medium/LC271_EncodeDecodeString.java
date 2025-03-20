//LC 271
/**
Step 1: Each string in the list is converted into a format that includes both the length of the string and the string itself.
Step 2: Use a delimiter or separator that is unlikely to appear in the strings (e.g., a special character like # or a specific character sequence like \n).
Decoding:
Step 1: Read the length of each string (encoded as part of the encoding process) and extract the respective number of characters.
Step 2: Continue until all encoded strings are decoded.

Time Complexity - O(N)
*/
class Solution {
    StringBuffer sb = new StringBuffer();
    public String encode(List<String> strs) {
        for(String str: strs){
        System.out.println("encode "+str+" d");
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> list = new ArrayList<String>();
        
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+length;
            String decodedString = str.substring(i,j);
            list.add(decodedString);
            i=j;
        }


        return list;
    }
}
