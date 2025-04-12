//Hashmap for frequency count
//HashSet for unique ness.
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        Set<Integer> set = new HashSet();

        for(int num: arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num: map.values()){
            if(set.contains(num)){
                return false;
            }
            set.add(num);
        }
        return true;
    }
}
