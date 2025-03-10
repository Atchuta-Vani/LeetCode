/**
    443 String Compression
    Two Pointers.
    Freq Map doesnot work.
 */
class Solution {
    public int compress(char[] chars) {

        if(chars.length == 0){
            return 0;
        }
        if(chars.length == 1){
            return 1;
        }

       int i = 0;
       int index = 0;
       while(i<chars.length){
        char currentChar = chars[i];
        int count = 0;
        while(i<chars.length && chars[i] == currentChar){
            i++;
            count++;
        } 
        chars[index++] = currentChar;
        if(count >1){
            for (char digit : Integer.toString(count).toCharArray()) {
                    chars[index++] = digit;
                }
        }
       
       }
     return index;                   

    }
}
