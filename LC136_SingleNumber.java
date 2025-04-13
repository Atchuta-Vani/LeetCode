//if xor two times, number is lost.
//136. Single Number
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums){
            xor ^= num;
        }
        return xor;
        
    }
}
