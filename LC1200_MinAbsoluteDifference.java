/*
Optimal Approach: Sorting + One-Pass Comparison
Pattern: Sorting + Single Pass to Find Minimum Difference
Steps:
Sort the Array:


Sort arr to simplify finding consecutive pairs with minimum absolute difference.
Find Minimum Absolute Difference:


Use a single pass to calculate the minimum absolute difference between consecutive elements.
Collect Pairs:


Perform another pass to collect all pairs with the minimum absolute difference.

*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int minDiff = Integer.MAX_VALUE; //Always assign to max value here.
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(arr);
        for(int i =0;i<arr.length-1; i++){
            int j=i+1;
            if(minDiff > arr[j]-arr[i]){
                minDiff = arr[j]-arr[i];
                result = new ArrayList();
                result.add(Arrays.asList(arr[i],arr[j]));
            }else if(minDiff == arr[j]-arr[i]){
                 List<Integer> l = new ArrayList();
                result.add(Arrays.asList(arr[i],arr[j]));
            }
        }
        return result;
        
    }
}
