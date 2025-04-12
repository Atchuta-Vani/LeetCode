class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int n = needle.length();
        int h =  haystack.length();
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
