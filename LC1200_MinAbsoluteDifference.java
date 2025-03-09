class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int minDiff = Integer.MAX_VALUE; //Always assign to max value here.
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(arr);
        for(int i =0;i<arr.length-1; i++){
            int j=i+1;
            if(minDiff > arr[j]-arr[i]){
                minDiff = arr[j]-arr[i];
                result = new ArrayList();
                result.add(Arrays.asList(arr[i],arr[j]));
            }else if(minDiff == arr[j]-arr[i]){
                 List<Integer> l = new ArrayList();
                result.add(Arrays.asList(arr[i],arr[j]));
            }
        }
        return result;
        
    }
}
