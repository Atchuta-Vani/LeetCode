class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            backtrack(candidates, curr,0,result,target);
        return result;
        
    }


    private void backtrack(int[] nums, List<Integer> curr, int start, List<List<Integer>> result,int target) {
        if(target==0) {
            result.add(new ArrayList<>(curr));
            //System.out.println("result "+result.toString());
            return;
        }
        if (target < 0 ) {//without this, it is going into infinite stackoverflow error
            return;
        }
        for(int k = start;k< nums.length; k++) {
            curr.add(nums[k]);
            backtrack(nums, curr, k, result,target-nums[k]);
            curr.remove(curr.size()-1);
        }
        return;
    }
}
