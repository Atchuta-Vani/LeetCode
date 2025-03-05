class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null || s.length() ==0 || words == null || words.length == 0){
            return result;
        }
        Map<String,Integer> wordMap = new HashMap<String, Integer>();
        int wordL = 0;
        int n = words.length;

        for(String str:words){
            wordL = str.length();
            wordMap.put(str,wordMap.getOrDefault(str,0)+1);
        }

        for(int i = 0;i<=s.length() - wordL*n;i++){
            Map<String, Integer> seenWords = new HashMap<String, Integer>();
            int j = 0;

            while(j<n){
                String subString = s.substring(i+j*wordL, i+(j+1)*wordL);
                if (!wordMap.containsKey(subString)) {
                        break;
                    }
                seenWords.put(subString,seenWords.getOrDefault(subString,0)+1);
                if(seenWords.get(subString) > wordMap.get(subString)){
                    break;
                }
                j++;
            }
            //System.out.println("j is"+j+" i is "+i);
            if(j == n){
                result.add(i);
            }
        }
        return result;
    }
}
