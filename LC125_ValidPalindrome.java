class Solution {
    public boolean isPalindrome(String s) {
        char ch1,ch2;
        int n = s.toCharArray().length;
        for(int i=0,j=n-1;i<j;){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            ch1 = Character.toLowerCase(s.charAt(i));
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            ch2 = Character.toLowerCase(s.charAt(j));
            if(ch1!=ch2){
//            System.out.println("Ch1 "+ch1+"ch2 "+ch2+"i :"+i+" j :"+j);
                return false;

            }
            i++;
            j--;
        }

        return true;
        
    }
}
