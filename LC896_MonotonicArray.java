/**
Initialize two booleans: increasing = true, decreasing = true

Loop through the array:

If any pair violates increasing order → set increasing = false

If any pair violates decreasing order → set decreasing = false

If either flag is still true after the loop → it's monotonic
 */
class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums==null || nums.length == 1)
            return true;

        boolean inc = true;
        boolean dec = true;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){// donot add = condition here. we need to change the flags if it is inc or dec only.
                inc = false;
            }else if (nums[i]>nums[i-1]){
                dec = false;
            }
                            
        }
        return (inc == true || dec == true)? true: false;
    }
}
