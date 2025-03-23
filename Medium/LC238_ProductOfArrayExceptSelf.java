/**
// 238. Product of Array Except Self
Declare three arrays suffix, prefix, and ans
initialize prefix[0] and suffix[n-1] to 1

prefix[i] = prefix[i-1] * nums[i-1]
suffix[i] = suffix[i+1] * nums[i+1]

ans[i] = prefix[i] * suffix[i]

TC: O(n)
SC: O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        //print(prefix);
        
        for(int j = n-2;j>=0;j--){
            suffix[j] = suffix[j+1] * nums[j+1];
        }
        //print(suffix);

        for(int k=0;k<n;k++){
            ans[k] = prefix[k] * suffix[k];
        }
        //print(ans);
        return ans;
    }

    public void print(int[] nums){
        for(int i = 0;i<nums.length;i++){
        System.out.print(" "+nums[i]);
        }
        System.out.println(" ");
    }
}
