// check 27 as well.
//26. Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int k = 1;k<nums.length;k++){
            if(nums[k] != nums[index]){ // Since it is sorted array, we can do this.
                index++;
                nums[index] = nums[k];
            }
        }
    return index+1;    
        
    }
}
