/** LC 46 Permutations
Back tracking. 
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
TC: O(N!)
SC: O(N!)
 */
class Solution {
     List<List<Integer>> result = new ArrayList<>();
     boolean[] pick;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return result;
        pick = new boolean[nums.length];
        permute(new ArrayList(),nums);
        return result;
    }

     void permute(List perm, int[] nums){
        if(nums.length == perm.size()){
            result.add(new ArrayList<Integer>(perm));
            return;
        }
            for(int i=0;i<nums.length;i++){
                if(!pick[i]){
                    perm.add(nums[i]);
                    pick[i] = true;
                    permute(perm,nums);
                    perm.remove(perm.size()-1);
                    pick[i] = false;
                }

            }

        return ;
    }
}
/**
Algorithm for Permutations
Initialize Data Structures:
Create a list res to store all possible permutations.
Define the Main Function (permute):
This function takes an integer array nums as input.
It initializes an empty list perm to store the current permutation.
It initializes a boolean array pick of size nums.length to track whether an element is already included in the current permutation.
It calls the recursive helper function backTrack(perm, nums, pick).
Recursive Backtracking Function (backTrack):
Base Case: If the perm list size equals nums.length, add a copy of perm to res and return.
Iterate Over Elements:
Loop through nums and check if the element is already picked using pick[i].
If nums[i] is not picked:
Mark it as picked (pick[i] = true).
Add nums[i] to perm.
Recursively call backTrack(perm, nums, pick).
After returning from recursion:
Remove the last element from perm (backtrack).
Mark pick[i] as false to allow reuse of the number in future iterations.
Return Result:
After recursion completes, return res, which contains all possible permutations.

Time and Space Complexity
Time Complexity: O(N!)O(N!)O(N!)
Since there are N!N!N! permutations of nums, and each permutation takes O(N)O(N)O(N) operations in the worst case.
Space Complexity: O(N)O(N)O(N) (excluding output storage)
Due to recursion depth of at most O(N)O(N)O(N) and the pick array storing NNN elements.
 */
