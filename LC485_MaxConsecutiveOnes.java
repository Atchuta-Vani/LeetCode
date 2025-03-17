//485 - Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            if(nums[right] == 1)
                count++;
            if(nums[right] == 0)
                count = 0;
        max = Math.max(max, count);
        }
        return max;
    }
}
