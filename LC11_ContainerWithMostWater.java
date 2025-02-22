// Two pointer approach
//Time Complexity - O(n)
//Space Complexity O(1)

class Solution {
    int maxArea = 0;
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        while(i<j){
            int w = j-i;
            int h = Math.min(height[j], height[i]);
            //System.out.println(i+" "+j +" and "+ w+" "+h);
            int area = w * h;
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {//max height holds more water, so keep moving to right if height is less
                i++;
            } else {
                j--;
            }
        }
    return maxArea;
    }
}
