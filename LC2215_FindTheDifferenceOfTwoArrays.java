//2215. Find the Difference of Two Arrays
//HashSet
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        List<List<Integer>> result = new ArrayList();
        Set<Integer> res1 = new HashSet();
        for(int num:nums1){
            if(!set2.contains(num)){
                res1.add(num);
            }
        }
        result.add(new ArrayList(res1));
        Set<Integer> res2 = new HashSet();
        for(int num:nums2){
            if(!set1.contains(num)){
                res2.add(num);
            }
        }
        result.add(new ArrayList(res2));
    return result;    
    }
}
