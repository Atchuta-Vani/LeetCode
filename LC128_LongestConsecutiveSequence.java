//128. Longest Consecutive Sequence
/**
Add all the numbers to HashSet.

iterate on nums array using for loop.
for each number n, if n-1 is not in set, start counter 
increment counter till you find n+1 in set. 
find max of counter and maxLength

return maxLength. 
 */

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet();
        int maxCount = 0;
        for(int n:nums){
            numSet.add(n);
        }
       for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                maxCount = Math.max(maxCount, length);
            }
        }
        return maxCount;
    }
}
