//Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++)
            if(nums[i]+nums[j] == target){

                result[0] = i;
                result[1] = j;
            }
        }
        return result;
        
    }
}

//Efficient way using hashmap.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] indices = new int[2];
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            int remainingNumber = target - n;
            if(map.containsKey(remainingNumber)){
                return new int[]{i,map.get(remainingNumber)};
            }
            else{
                    map.put(n,i);
            }
        }
    return indices;
    }
