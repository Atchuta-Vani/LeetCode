//202. Happy Number  - 
//Write an algorithm to determine if a number n is happy.

//A happy number is a number defined by the following process:
class Solution {
    //Hash set to check if sum is already seen
    Set<Integer> set = new HashSet();
    public boolean isHappy(int n) {
        int sum = 0;
        //calculate sum of squares of digits.
        while(n>0){
            int digit = n%10;
            sum+=digit * digit;            
            n = n/10;
        }
        //if set already has sum, loop is found, so return false.
        if(set.contains(sum))
            return false;
        else
            set.add(sum);
        //if sum is 1 return true , otherwise calls isHappy again for the sum.                 
        if(sum == 1)
            return true;
        return isHappy(sum);        
    }
}
