package LC;

public class LC408 {
    public static void main(String[] args){
        LC408 solution = new LC408();
        //boolean result = solution.validWordAbbreviation("internationalization","i12iz4n");
        //boolean result = solution.validWordAbbreviation("internationalization","i5a11o1");
        boolean result = solution.validWordAbbreviation("hi","1");
        System.out.println(result);
    }
    public boolean validWordAbbreviation(String word, String abbr) {
        int number = 0;
        int j = 0;
        int i = 0;
        while(i<abbr.length() && j < word.length()){

            if(Character.isDigit(abbr.charAt(i))){
                if(abbr.charAt(i) == '0') return false;
                while(i<abbr.length() && Character.isDigit(abbr.charAt(i))){
                    number = number * 10+(abbr.charAt(i) - '0');
                    i++;
                }
                j += number;
            } else{// not digit, check if char at word is same as char at abbr
                    number = 0;
                    if(word.charAt(j) != abbr.charAt(i) ){
                        return false;
                    }
                    i++;
                    j++;
            }
        }
        boolean processed = i == abbr.length() && j == word.length();
        return processed;
    }
}
