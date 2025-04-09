package LC;

import java.util.HashMap;
import java.util.Map;

public class LC246_StrobogrammaticNumber {
    public static void main(String[] args){
        LC246_StrobogrammaticNumber solution = new LC246_StrobogrammaticNumber();
        boolean result1 = solution.isStrobogrammatic("69");
        boolean result2 = solution.isStrobogrammatic("88");
        boolean result3 = solution.isStrobogrammatic("692");
        System.out.println("result "+result1+" "+result2+" "+result3);
    }
    Map<Character, Character> numberMap = new HashMap();
    public boolean isStrobogrammatic(String num) {
        numberMap.put('0','0');
        numberMap.put('6','9');
        numberMap.put('9','6');
        numberMap.put('1','1');
        numberMap.put('8','8');
        int i = 0;
        int j = num.length()-1;
        while(i<=j){
            char ch1 = num.charAt(i);
            char ch2 = num.charAt(j);
            if(!numberMap.containsKey(ch1) || !numberMap.containsKey(ch2) || numberMap.get(ch1) != ch2){
                return false;
            }
            i++;
            j--;
        }
    return true;
    }
}
