package LC;

import java.util.ArrayList;
import java.util.List;

public class LC346_MovingAverage {
    List<Integer> list;
    double sum;
    int size;
    public static void main(String[] args) {
        LC346_MovingAverage solution = new LC346_MovingAverage(3);
        System.out.println(solution.next(1));
        System.out.println(solution.next(3));
        System.out.println(solution.next(4));
        System.out.println(solution.next(5));

    }


        public LC346_MovingAverage(int size) {
            this.size = size;
            list = new ArrayList<Integer>(size);
        }

        public double next(int val) {
        if(list.size()<this.size){
            list.add(val);
            sum += val;
        }else{
            int oldValue = list.remove(0);
            list.add(val);
            sum-=oldValue;
            sum+=val;
        }
        return (double)sum/list.size();
        }

}
//10,1,1,,1 = 13/3*3 = 13 -10+2 =5/3
