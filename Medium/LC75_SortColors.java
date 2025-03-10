class Solution {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //System.out.println(map);
        int count = 0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            for(int j=0;j<e.getValue();j++){                
                nums[count] = e.getKey();
                count++;
            }            
        }        
    }
}
