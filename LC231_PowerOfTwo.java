// 0, 1,2 ,3,4,5
//1,10(2),100(4),1000(8)

/**
we are looking for numbers of bit form
1 follwed by zeros
10
100
1000

so 
8 = 1000
7 = 0111
& operation = 0

return true 

else 
return false

 */
class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n <= 0)
            return false;
        int bit = 1;
        for(int i = 0;i<32;i++){
            //int result = n & bit;
            if (bit == n){
                return true;
            }
            bit = bit<<1;
        }
        return false; 

        //return n > 0 && (n & (n-1)) ==0;        
        
    }
}
