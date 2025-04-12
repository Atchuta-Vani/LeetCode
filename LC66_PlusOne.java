class Solution {
    public int[] plusOne(int[] digits) {
        List list = new ArrayList();
        int n = digits.length;
        for(int i = n-1;i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int[] result = new int[n+1]; // if we reach here, that means all are 9s
        result[0] =1 ;
        return result;
    }
}
