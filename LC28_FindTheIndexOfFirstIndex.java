//Sliding window.
//28 Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int n = needle.length();
        int h =  haystack.length();
        if(n == 0){
            return 0;
        }

        for(int right = n-1; right<h; right++){
            String str = haystack.substring(left,right+1); 
            //System.out.println("substring"+ str);           
            if(str.equals(needle))
                return left;
            left++;                
        }
        return -1;
    }
}
