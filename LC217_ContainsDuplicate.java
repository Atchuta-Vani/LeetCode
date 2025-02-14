//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

//Hint, HashSet can be used as it contains unique values. HashSet.add method returns true if number is added to Set or false, if it is not added to Set. We can use this to find if number already exists. 
// Alternate Approach, HashMap can be used as well.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n:nums){
            if(!set.add(n))
                return true;
        }
        return false;
    }
}
