class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int l = 0,  maxF = 0;
        int res = 0;
        int[] count = new int[26];
        for(int r = 0; r < s.length(); r++){
            count[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(r) - 'A']);
            while((r - l + 1) - maxF > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
