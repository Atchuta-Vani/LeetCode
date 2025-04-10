package LC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Start from last building (rightmost)
 *
 * Track maximum height seen so far
 *
 * Collect indices where building height > maxHeightSoFar
 */
public class LC1762_OceanView {
    public int[] findBuildings(int[] heights){
        int maxHeight = -1;
        List<Integer> result = new ArrayList<>();
        for(int i = heights.length-1;i>=0;i--){
            if(heights[i] > maxHeight){
                maxHeight = heights[i];
                result.add(i);
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
