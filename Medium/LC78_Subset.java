/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int length = 1; length<=nums.length; length++) {
            List<Integer> curr = new ArrayList<>();
            backtrack(nums, length, curr,0,result);
        }
        result.add(new ArrayList());
        return result;
    }

    public void backtrack(int[] nums, int length, List<Integer> curr, int start, List<List<Integer>> result) {
        if(length==curr.size()) {
            result.add(new ArrayList<>(curr));
            //System.out.println("result "+result.toString());
            return;
        }
        for(int k = start;k< nums.length; k++) {
            curr.add(nums[k]);
            backtrack(nums, length, curr, k+1, result);
            curr.remove(curr.size()-1);
        }
        return;
    }
}
