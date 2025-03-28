class Solution {
    public boolean canPartition(int[] nums) {

        if(Arrays.stream(nums).sum()%2 != 0)
            return false;
        int target = Arrays.stream(nums).sum()/2;
        Set<Integer> dp = new HashSet();
        dp.add(0);

        for(int i = nums.length - 1;i>=0;i--){
            Set<Integer> nextDP = new HashSet();
            for(int t:dp){
                if(nums[i]+t == target){
                    return true;
                }
                nextDP.add(t+nums[i]);
                nextDP.add(t);
                //System.out.println(nextDP);
            }
            dp = nextDP;
        }
    return false;
    }
}
