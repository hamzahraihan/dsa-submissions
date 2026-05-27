class Solution {
    // tip: to find current window size use this formula (r - l + 1)
    public int characterReplacement(String s, int k) {
        // create a window count
        int[] window = new int[26];
        int res = 0;
        int l = 0;
        int maxFreq = 0;

        for(int r = 0; r < s.length(); r++){
            // count window
            window[s.charAt(r) - 'A']++;
            // find the maximum count string of the same char
            maxFreq = Math.max(maxFreq, window[s.charAt(r) - 'A']);
            while((r - l + 1) - maxFreq > k){
                window[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
