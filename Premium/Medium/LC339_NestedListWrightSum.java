package LC;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//BFS
public class LC339_NestedListWrightSum {
    public interface NestedInteger {
        public boolean isInteger();
        public List getList();
        public Integer getInteger();
    }

    public int depthSum(List<NestedInteger> nestedList) {

    Queue<NestedInteger> queue = new LinkedList<>(nestedList);
    int depth = 1;
    int sum = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0;i<size;i++){
            NestedInteger ni = queue.poll();
            if(ni.isInteger()){
                sum += ni.getInteger() * depth;
            }else{
                List<NestedInteger> list = ni.getList();
                queue.addAll(list);
            }
        }
        depth++;
    }
    return sum;
    }
}
