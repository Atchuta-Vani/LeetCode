class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int sum = 0;
        for(int i = 0;i< s.length();i++){
            char ch = s.charAt(i);
            String str = new Character(ch).toString();
            int val = map.get(str);
            if(i<s.length()-1){
                char chNext = s.charAt(i+1);
                String mixString = s.substring(i,i+2);           
                 if(map.containsKey(mixString)){
                        int nextVal = map.get(mixString);
                        sum +=nextVal;
                        i++;
                        continue;
                    }
            }

            sum+=val;
        }
    return sum;
    }
}
