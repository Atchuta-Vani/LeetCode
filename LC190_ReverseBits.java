/**
iterate on 32 bits
shift left on result to make room for bit at the end.

n&1 = to get bit at the end
or it with result to keep at the end of result;
right shift n byt 1 to get to next bit.
*/
//190. Reverse Bits
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0;i<32;i++){
            result<<=1;
            result|=(n&1);
            n>>>=1; //(>>> unsigned right shift fills left most sign bit with 0.)
        }
        return result;
    }
}
