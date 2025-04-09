/**
 * find missing range between nums[i] and nums[i-1]
 *
 * keep decrementing k till this falls less than missing number
 *
 */

package LC;

public class LC1060_MissingElement {

    public int missingElement(int[] nums,int k){
        for(int i = 1;i<nums.length;i++){
            int missingNumber = nums[i] - nums[i-1]-1;
            if(k<=missingNumber){
                return nums[i-1]+k;
            }
            k-=missingNumber;
        }
        return nums[nums.length -1] + k;
    }

}
