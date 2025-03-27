//55 Jump Game.
//Greedy Approach.
/**
Steps:
Initialize a variable farthest to 0, which tracks the farthest index we can reach at each step.

Iterate through the array. For each index i, check if it's reachable (i.e., i <= farthest).

If it is, update farthest to be the maximum of its current value and i + nums[i].

If farthest reaches or exceeds the last index (n - 1), return True.

If we finish iterating and farthest is still less than the last index, return False
TC:  O(n),
SC: O(1)
 */
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0;i<nums.length;i++){           
            if(i>farthest){
                return false;
            }
            farthest = Math.max(farthest, i+nums[i]);
        }
    return true;        
    }
}
