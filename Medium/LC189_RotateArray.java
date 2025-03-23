/**
189. Rotate Array
for rotating array by k times, 
reverse entire array.
reverse 0 to k-1
reverse k to n-1

TC O(n) 
SC O(1) 
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        reverse(nums, 0,n-1);
        reverse(nums, 0,k-1);
        reverse(nums, k,n-1);

    /*for(int j = 0;j<k;j++){
        int last = nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--){

            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }*/    
    }

    public void reverse(int[] nums, int start, int end){
        int temp;
        while(start<end){
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
