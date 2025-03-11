/**
300. Longest Increasing Subsequence
Dynamic programming. 
a[i] is greater and find longest LIS in j - 1 to i. 
 */

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        int maxLength=1;
        for (int i =0; i <nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] ) {
                    LIS[i] = Math.max(LIS[i],1+LIS[j]);
                }
            }
            maxLength = Math.max(maxLength, LIS[i]);
        }
        return maxLength;
    }
}
