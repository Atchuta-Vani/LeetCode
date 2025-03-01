//TC - (log max(p)) * length of piles
//SC - 
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();//Binary search from 1 to max number of pile
        int res = r;
        while (l <= r) {
            int k = l+(r-l) / 2;
            long total=0;
            for (int p : piles) {
                total+=Math.ceil((double)p / k);
            }
            if (total > h) {
                l = k + 1;
            }else{
                res = k;
                r = k-1;
            }
        }
        return res;
    }
}
