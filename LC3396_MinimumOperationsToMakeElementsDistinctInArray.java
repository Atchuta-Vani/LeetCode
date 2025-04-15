/**
🧠 Pattern:
✅ Sliding Window + Greedy Trimming from Start
✅ Set for Uniqueness Check
Loop from 0 to nums.length in steps of 3 (these are the number of elements removed).

At each step, slice the array from i to the end.

Check if that slice has all distinct elements.

As soon as we find such a case, return the number of operations done (i / 3).

 */

class Solution {
    public int minimumOperations(int[] nums) {
        int i = 0;
        int n = nums.length;
        for(i=0;i<n;i=i+3){
            Set<Integer> set = new HashSet();
            boolean unique = true;
            for(int j = i;j<n;j++){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);                
                }else{
                    unique = false;                    
                }
            }
            if(unique){
                return i/3;
            }

        }
    return i/3;    
    }
}
