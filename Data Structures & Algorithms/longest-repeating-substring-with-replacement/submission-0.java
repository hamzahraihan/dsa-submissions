class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, maxF = 0;
        int[] count = new int[90];
        int res = 0;
        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(right) - 'A']);

            while((right - left + 1 ) - maxF > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
