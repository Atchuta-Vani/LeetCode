//Merge Sort
// TC - O(nlogn)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.io.ObjectInputFilter.merge;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4,8,9, 3, 8, 1,5,5, 9);
        System.out.println(Arrays.toString(list.toArray()));
        List<Integer> mergedList = mergeSort(list);
        System.out.println(Arrays.toString(mergedList.toArray()));
    }

    private static List<Integer> mergeSort(List<Integer> list) {
        int n = list.size();
        if(n <= 1) return list;
        int mid = n/2;
        List<Integer> left = new ArrayList<>(list.subList(0,mid));
        List<Integer> right = new ArrayList<>(list.subList(mid,n));
        //System.out.println("left "+ Arrays.toString(left.toArray()));

        //

        left = mergeSort(left);
        right = mergeSort(right);
        List<Integer> mergedList = merge(left,right);
        //System.out.println(Arrays.toString(mergedList.toArray()));
        return mergedList;

    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>(left.size() + right.size());
        while(left.size() > 0 && right.size() >0){
            if(left.get(0) < right.get(0)){
                result.add(left.get(0));
                left.remove(0);
            }else{
                result.add(right.get(0));
                right.remove(0);
            }

        }
        while(left.size() > 0){
            result.add(left.get(0));
            left.remove(0);
        }
        while(right.size() > 0){
            result.add(right.get(0));
            right.remove(0);
        }
    return result;
    }
}
