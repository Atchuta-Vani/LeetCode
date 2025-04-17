//DP . 
/**
💡 Approach (Max Product Subarray):
Track two values at each step:
maxSoFar: max product ending at current index
minSoFar: min product ending at current index (needed for negatives)

Iterate through the array:
If nums[i] is negative, swap maxSoFar and minSoFar

Return maxProduct

 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }
            
            maxProduct = Math.max(maxProduct*nums[i],nums[i]);
             minProduct = Math.min(nums[i], minProduct * nums[i]);
            
            result = Math.max(maxProduct,result);
        }
        return result;
    }
}
