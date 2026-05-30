class Solution {
    public boolean isPalindrome(String s) {
        String word = "";
        for(char ch : s.toCharArray()){
            if(ch == ' ') continue;
            if(!Character.isLetterOrDigit(ch)){
                continue;
            }
            word += ch;
        }
        String lowerWord = word.toLowerCase();

        int r = word.length() - 1;
        for(char ch : lowerWord.toCharArray()){
            if(ch != lowerWord.charAt(r)){
                return false;
            }
            r--;
        }
        return true;
    }
}
