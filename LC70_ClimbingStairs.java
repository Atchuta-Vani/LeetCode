//LC 70 Climbing Stairs - Fibonocci Series
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

class Solution {
    int cnt = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        return count(n);
    }

    public int count(int n){


    if (n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        } else {
            if(!map.containsKey(n-1)){
                map.put(n-1,count(n-1));
            }if(!map.containsKey(n-2)){
                map.put(n-2,count(n-2));
            }

             cnt = map.get(n-1) + map.get(n-2);
            //System.out.println(cnt);
            return cnt;
            //2,3,5,8,13

        }
    }
}
