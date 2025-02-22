import java.util.ArrayList;
import java.util.List;

class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = {{1,4},{3,8},{9,10}};
        print(mergeIntervals(intervals));
    }
    public static void print(int[][] result){
        System.out.print("[");
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }

        }
        System.out.print("]");
    }
    public static int[][] mergeIntervals(int[][] intervals) {

            List<int[]> list = new ArrayList<int[]>();
            if(intervals.length == 0) return new int[][]{};
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            list.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                //System.out.println("Current Left and Right are "+interval[0]+" "+interval[1]);

                int[] result = list.get(list.size()-1);
                int left = result[0];
                int right = result[1];
                //System.out.println("Left and Right are "+left+" "+right);
                if(right >= interval[0]) {//merge interval
                    right = Math.max(right, interval[1]);
                    list.remove(list.size() - 1);
                    list.add(new int[]{left,right});
                    //System.out.println(right);
                }if(right < interval[0]) {
                    //add new interval
                    list.add(intervals[i]);
                }
            }
            return list.toArray(new int[list.size()][]);

        }
    }


