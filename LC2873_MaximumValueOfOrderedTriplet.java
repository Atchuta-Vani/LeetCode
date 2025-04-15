/**
We want:

The biggest value before position j (for nums[i])

The biggest value after position j (for nums[k])

To compute (nums[i] - nums[j]) * nums[k] and track the maximum

🎯 Pattern:
✅ Prefix Maximum: Best nums[i] seen so far before j

✅ Suffix Maximum: Best nums[k] after j

//2873. Maximum Value of an Ordered Triplet I
 */
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long[] suffix = new long[n];
        long[] prefix = new long[n];
        suffix[n-1] = nums[n-1];

        prefix[0] = nums[0];
        for(int i = n-2;i>=0;i--){
            suffix[i] = Math.max(nums[i],suffix[i+1]);
        }

        for(int i = 1;i<n;i++){
            prefix[i] = Math.max(nums[i],prefix[i-1]);
        }
        long result = 0;
        for(int j = 1;j< n-1;j++){
           long curResult = (prefix[j-1] - nums[j])*suffix[j+1];
           //System.out.println("nums[j] "+nums[j]+"prefix[j-1] "+prefix[j-1]+" suffix[j+1] "+suffix[j+1]+" curResult "+curResult);
           result = Math.max(result, curResult);
        }
    return result;
    }
}
