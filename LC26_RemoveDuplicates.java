// check 27 as well.
//26. Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            while(right+1<nums.length && nums[right] == nums[right+1]) right++;
            nums[left] = nums[right];
            left++;
        }
    return left;    
        
    }
}
