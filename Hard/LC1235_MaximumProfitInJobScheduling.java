/**
Steps:
Sort the Jobs:

Sort the jobs based on their endTime. This ensures that we process jobs in the order of their finishing time, which is crucial for dynamic programming.

Define DP Transition:

For each job i, the maximum profit can be computed as:
dp[i]=max(dp[i−1],profit[i]+dp[last_index])
where last_index is the index of the last job that ends before the current job starts. We can find this index using binary search.

Binary Search:

For each job i, we perform binary search on jobs from 0 to i-1 to find the index of the last job that ends before jobs[i].startTime.

Final Result:

The answer is stored in dp[n-1], where n is the number of jobs.
 */

class Solution {
    class Job{
        int startTime;
        int endTime;
        int profit;
        Job(int startTime, int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        Job[] jobs = new Job[n];        
        for(int i = 0;i<n;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,(a,b)->a.endTime - b.endTime);
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for(int i = 1;i<n;i++){            
            int includeProfit = jobs[i].profit;

            int lastIndex = binarySearch(jobs,i);
            //System.out.println("lastIndex "+lastIndex +" i is "+i);
            if(lastIndex != -1){
                //includeProfit += profit[lastIndex];
                includeProfit += dp[lastIndex];
            }
            dp[i] = Math.max(dp[i-1],includeProfit);
        }
        //for(int d:dp)
        //System.out.println(d);
        return dp[n-1];
    }


    public int binarySearch(Job[] jobs,int index){
        int low = 0;
        int high = index-1;
        int target = jobs[index].startTime;
        while(low<=high){
            int mid = low+(high-low)/2;
             if (jobs[mid].endTime <= target) {
                if (mid == high || jobs[mid + 1].endTime > target) {
                    return mid;
                }
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

}
