/**
i >> 1 is i / 2 (bitwise right shift).

For example, if i = 5 (binary 101):

5 >> 1 = 2 (binary 10) → we've already computed how many bits are in 2.

5 & 1 = 1 → because 5 is odd, so it has one extra 1.

So, countBits(5) = countBits(2) + 1.
338. Counting Bits
 */
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0;i<=n;i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }
    return ans;    
    }

    
}
