/**
Approach:
We can use a greedy algorithm to try planting flowers in the flowerbed while ensuring the condition of no adjacent flowers is met.

Traverse the flowerbed:

For each spot that is 0 (empty), check if its adjacent spots (if they exist) are also 0. If they are, we can plant a flower here and increment n.
Greedy Strategy:

Always try to plant flowers starting from left to right. If a flower can be planted at position i, mark it by setting flowerbed[i] = 1 and move to the next available position (skip checking the next spot, since it's now adjacent to the newly planted flower).
Edge Cases:

When flowerbed is empty.
When n is 0 (no flowers to plant).
When there are not enough spots to plant all n flowers.
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n == 0 || flowerbed.length == 0) {
            return true;
        }

        for(int i = 0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                if((i==0||flowerbed[i-1] == 0) && (i==flowerbed.length-1 || flowerbed[i+1] == 0)){
                    flowerbed[i] = 1;
                    n--;
                    //System.out.println("i "+i);
                }
                if(n == 0){
                    return true;
                }
            }
        }
        return n<=0;
    }
}
