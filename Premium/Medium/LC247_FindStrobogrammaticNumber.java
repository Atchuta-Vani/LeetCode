package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC247 {
    public static void main(String[] args){
        System.out.println(findStrobogrammatic(2));//[69, 96, 88, 11]
        System.out.println(findStrobogrammatic(3));//[619, 916, 818, 111, 609, 906, 808, 101, 689, 986, 888, 181]
    }
    public static List<String> findStrobogrammatic(int n) {
        return build(n,n);
    }
    public static List<String> build(int n, int totalLength){

        if(n == 0) return Arrays.asList("");
        if(n == 1) return Arrays.asList("1","0", "8");

        List<String> list = build(n-2,totalLength);
        List<String> result = new ArrayList();
        for(String s: list){
            if(n!=totalLength){
                result.add("0"+s+"0");
            }
            result.add("6"+s+"9");
            result.add("9"+s+"6");
            result.add("8"+s+"8");
            result.add("1"+s+"1");
        }
        return result;
    }
}
