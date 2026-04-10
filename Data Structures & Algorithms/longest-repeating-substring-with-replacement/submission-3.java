class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[26];
        int l = 0, maxFreq = 0;
        int res = 0;
        int n = s.length();
        for(int r = 0; r < n; r++){
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);
            while((r - l + 1) - maxFreq > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
