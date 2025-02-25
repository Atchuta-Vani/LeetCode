//Letter Combination of Phone number
//Back tracking problem. for 23, return { ad ae af,bd,be,bf,cd,ce,cf}
//TC - O(n*4 to the power n)
//SC - O(n)

class Solution {
    List<String> result = new ArrayList<String>();
    String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return result;
        backtrack(0,new StringBuilder(),digits);
        return result;
    }
    void backtrack(int index, StringBuilder currString, String digits){
        if(currString.length() == digits.length()){
            result.add(currString.toString());
            return;
        }
        //find char sequence for the character
           String charSequence =  phone[digits.charAt(index) - '0'];
           for(char ch: charSequence.toCharArray()){
                currString.append(ch);
                backtrack(index+1, currString, digits);
                currString.deleteCharAt(currString.length()-1);

           }
    }
}
