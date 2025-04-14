/**
GCD of two numbers is a number that can dividie both integers.
1979. Find Greatest Common Divisor of Array
 */
class Solution {
    public int findGCD(int[] nums) {
        int gcd = 0;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int n : nums){
            smallest = Math.min(smallest,n);
            largest = Math.max(largest,n);
        }
        return GCD(smallest,largest);
    }

    public int GCD(int a, int b) {
        int min = Math.min(a, b);
        //System.out.println("min "+min);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i; // Found the greatest common divisor
            }
        }

        return 1; // If no other common divisors are found
    }
}
