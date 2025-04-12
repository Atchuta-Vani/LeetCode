// 27. Remove Element

/**
Traverses the array.

If the element is not val, it writes it at the current index and increments the index.

At the end, index will be the length of the array without the val elements.

 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
    return index;        
    }
}
