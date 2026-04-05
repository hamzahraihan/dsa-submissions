class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        String lowerCase = sb.toString();

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
