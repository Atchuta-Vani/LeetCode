class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            if(map.get(n) > nums.length/2){
                return n;
            }
        }
    //There is no major element.
    return -1;
    }
}
