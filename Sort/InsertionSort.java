//Neet Code Insertion Sorting
/*
Input:

pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
Example 1:

Input:
pairs = [(5, "apple"), (2, "banana"), (9, "cherry")]

Output:
[[(5, "apple"), (2, "banana"), (9, "cherry")], 
 [(2, "banana"), (5, "apple"), (9, "cherry")], 
 [(2, "banana"), (5, "apple"), (9, "cherry")]]
*/

//TC: O(n2)

// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        List<List<Pair>> result = new ArrayList<List<Pair>>();

        for(int i = 0;i< pairs.size();i++){

            int j = i;
            while (j > 0 && pairs.get(j-1).key > pairs.get(j).key){
                Pair pairAtJ = pairs.remove(j);
                pairs.add(j-1,pairAtJ);
                //swap(pairs,j-1,j); //no need for this method.
                j--;
            }
            result.add(new ArrayList(pairs));


        }
    return result;
    
    }
    void swap(List<Pair> pairs, int i, int j){
        Pair temp = pairs.remove(j);        
        pairs.add(i,temp);

    }
}
