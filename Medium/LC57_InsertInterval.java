/**
Traverse the list of intervals to find three distinct sections:

Intervals before the new interval: Add all intervals that end before newInterval starts to the result list. These intervals don't overlap with the new interval, so they can be added as-is.

Merging overlapping intervals: For intervals that overlap with newInterval, merge them. Overlap occurs when the current interval’s start time is less than or equal to newInterval's end time, and the current interval’s end time is greater than or equal to newInterval's start time. Update newInterval to reflect the merged range by taking the minimum of the current interval’s start and newInterval's start, and the maximum of their end times.

Intervals after the new interval: Once all overlapping intervals are merged, add any remaining intervals that start after newInterval ends to the result list.
 */
//57. Insert Interval
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        if(intervals.length == 0){
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }
       
        int i = 0;
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        while(i<n && intervals[i][1]<newInterval[0]){
             result.add(intervals[i]);
             i++;
        }
         //System.out.println(i+""+intervals[i][1]);
        //merge logic.. Tricky
        int right = newInterval[1];
        while(i<n && newInterval[1] >=intervals[i][0]){ 
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);            
            i++;
        }
        result.add(newInterval);
        //rest of intervals
        while(i<n){
            result.add(intervals[i]);
            i++;
        }


        return result.toArray(new int[result.size()][]);
    }
}
