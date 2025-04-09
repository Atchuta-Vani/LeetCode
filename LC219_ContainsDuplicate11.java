//219. Contains Duplicate II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int diff = i - map.get(nums[i]);
                if(diff <= k){
                    return true;
                }else{
                     map.put(nums[i] , i);
                }
            }else{
                map.put(nums[i] , i);
            }
        }
    return false;    
    }
}
