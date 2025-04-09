package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC163_MissingRanges {
    public static void main(String[] args) {
        LC163_MissingRanges solution = new LC163_MissingRanges();
        int[] n = {0, 1, 3, 50, 75};
        List<List<Integer>> result = solution.findMissingRanges(n,0,99);
        System.out.println("result"+result);
    }

        public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0; i< nums.length;i++){
                if(i == 0 && nums[i]>lower){
                    result.add(Arrays.asList(lower,nums[i] -1));
                    continue;
                }
                if(i==0 || (i<nums.length && nums[i]  == nums[i-1]+1)){
                    continue;
                }
                result.add(Arrays.asList(nums[i-1]+1,nums[i]-1));
            }
            if(nums[nums.length-1]<upper){
                result.add(Arrays.asList(nums[nums.length-1]+1,upper));
            }
            return result;
        }
}
