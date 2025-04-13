//389. Find the Difference
//Bit Manipulation.
class Solution {
    public char findTheDifference(String s, String t) {

        int xor = 0;
        for(char ch1:s.toCharArray()){
            xor ^= ch1;
        }
        for(char ch2:t.toCharArray()){
            xor ^= ch2;
        }
        return (char) xor;
        
    }
}
