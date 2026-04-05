class Solution {
    public boolean isPalindrome(String s) {
        String sString = "";
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                continue;
            }
            if(!Character.isLetterOrDigit(ch)){
                continue;
            }
            sString += ch;
        }
        String lowerCase = sString.toLowerCase();

        int right = lowerCase.length() - 1;
        for(char ch : lowerCase.toCharArray()){
            if(ch != lowerCase.charAt(right)){
                return false;
            }
            right--;
        }
        return true;
    }
}
