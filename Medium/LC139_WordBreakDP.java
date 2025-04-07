/**
Dynamic Programming State
Define:
dp[i] = true if s[0..i-1] (substring of first i characters) can be segmented
✅ Transition:
For each i from 1 to n:
For each j from 0 to i-1, check:
If dp[j] == true
And s.substring(j, i) is in the dictionary
Then set dp[i] = true and break
✅ Base case:
dp[0] = true (empty string is always "segmented")
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;
        int n = s.length();

        for(int i = 1;i<=n;i++) // include n because dp[0] is set to true.
            for(int j = 0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; // once one word is found break the loop.
                }
            }
        return dp[n];
    }
}
