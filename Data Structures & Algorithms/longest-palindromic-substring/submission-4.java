class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0, resIdx = 0;
        for(int i = 0; i < s.length(); i++){
            int l = i, r = i;
            // odd length
            // use one character as center
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > resLen){
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            // even length, if between character is the same
            // use two characters as a center
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > resLen){
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}
