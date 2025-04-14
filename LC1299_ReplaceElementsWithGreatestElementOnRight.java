/**
Step-by-step thinking:
Start from the end of the array (rightmost element).
Keep track of the current maximum you've seen so far.

For each element:
Store the original value temporarily.
Replace the current element with the current maximum.
Update the current maximum if needed.
 */
class Solution {
    //using dynamic programming. newArray[i] = Max of(arr[i+1],newArray[i+1]);
    /*
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] newArray = new int[n];
        newArray[n-1] = -1;
        for(int i =n-2;i>=0;i--){
            newArray[i] = Math.max(arr[i+1],newArray[i+1]);
        }
    return newArray;
    }*/
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxCurrent = -1;
        for(int i = n-1;i>=0;i--){
            int current = arr[i];
            arr[i] = maxCurrent;
            maxCurrent = Math.max(maxCurrent, current);
        }
        return arr;
    }
}
