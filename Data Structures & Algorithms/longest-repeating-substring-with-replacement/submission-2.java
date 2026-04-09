class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] count = new int[26]; 

        int res = 0, l = 0;
        int maxF = 0;

        for(int r = 0; r < n; r++){
            count[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(r) - 'A']);

            while((r - l + 1) - maxF >  k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
