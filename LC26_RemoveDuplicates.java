class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        
        for(int r = 0;r<nums.length;r++){
            if(r<nums.length-1 && nums[r] == nums[r+1]){
                //l = r+1;
                while(r<nums.length-1 && nums[r] == nums[r+1]){
                    r++;
                }
            }    
            
            
            //System.out.println("l "+l+"r "+r);
            nums[l] = nums[r];
            //r++;
            l++;
        }
    return l;        
    }
}
