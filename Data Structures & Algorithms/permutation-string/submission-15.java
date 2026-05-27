class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // if string s1 is more than s2 length meaning that permutation wont happen (edge case)
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        // we count the window size for s2Count
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        // we count every match character int s1Count and s2Count
        for(int i = 0; i < 26; i++){
            if(s1Count[i] == s2Count[i]){
                matches++;
            }
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            // check if s1count[i]('c') is equal to s2count[index] ('c')
            if(s1Count[index] == s2Count[index]){
                matches++;
            } else if(s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            // now we remove left window
            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            // we check if the left window has same character in s1Count 
            if(s1Count[index] == s2Count[index]){
                matches++;
            } else if(s1Count[index] - 1 == s2Count[index]) { // if it has lesser, than we decrease the match chars
                matches--;
            }
            l++;
        }

        return matches == 26;
    }
}
