class Solution {
    public int myAtoi(String s) {
        if (s == null || s.trim().isEmpty()) return 0;  // handle null or empty input
        
        String input = s.trim();
        boolean negative = false;
        int index = 0;
        
        // Check for negative or positive sign
        if (input.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (input.charAt(index) == '+') {
            index++;
        }

        // Remove leading zeros
        while (index < input.length() && input.charAt(index) == '0') {
            index++;
        }
        
        // If the string becomes empty after removing leading zeros, return 0
        if (index == input.length()) return 0;

        long result = 0;
        
        for (int i = index; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                break;  // stop when non-digit character is found
            }

            // Prevent overflow
            int digit = ch - '0';
           

            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        // Apply negative sign if necessary
        return (int) (negative ? -result : result);
    }
}

/*

//result = result * 10 + (ch - '0');  312
0+3 = 3
30+1 = 31
310+2
//res += (s1.charAt(i)-'0')*Math.pow(10,s1.length()-i-1);

300
300+10 = 310
310+2

*/
