//42. Trapping Rain Water
/**
Using Prefix and suffix.

Declare two arrays to hold MAX left height, MAX right height.
Initialize leftHeight[0] and rightHeight[n-1] to height[0] and height[n-1]

Iterate on height array using for loop calculate leftHeight[i] as MAX of left height[i-1], height[i] 
Iterate on height array using for loop calculate rightHeight[i] as MAX of right height[i+1], height[i] 

calculate result as Min(Left, right) - Height[i] and add all of it.
return result.

TC O(n)
SC O(n)
 */

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int n = height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];

        leftHeight[0] = height[0];
        rightHeight[n-1] = height[n-1];

        for(int i = 1;i<n;i++){
            leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
            //System.out.print(leftHeight[i]);
        }

        for(int i = n-2;i>=0;i--){
            rightHeight[i] = Math.max(rightHeight[i+1], height[i]);
            //System.out.print(rightHeight[i]);
        }
        int result = 0;

        for(int i = 0;i<n;i++){
            // res is never negative.
            //int res = Math.min(leftHeight[i],rightHeight[i]) - height[i];
            //System.out.println(" "+Math.min(leftHeight[i],rightHeight[i]) + " "+height[i]);
            result += Math.min(leftHeight[i],rightHeight[i]) - height[i];
        }
    return result;    
    }
}
