class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i< nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;// from 1st index, check for duplicates and continue.

            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){//this is needed otherwise it will get only one value result
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    Integer[] array = {nums[i],nums[j],nums[k]};
                    result.add(Arrays.asList(array));
                    while (j<nums.length-1 && nums[j] == nums[j + 1]) j++;
                    while (k>0 && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }else if (sum>0){
                    k--;
                }else if (sum<0){
                    j++;
                }
            }
            
            //while(j<nums.length-1){if(nums[j] == nums[j+1]) j++;}
            //while(k>0){if(nums[k] == nums[k-1]) k--;}
        }
        return result;
        
    }
}
