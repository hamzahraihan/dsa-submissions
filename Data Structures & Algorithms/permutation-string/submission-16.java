class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        // s1Count as a target array
        int[] s1Count = new int[26];
        // s2Count for window array
        int[] s2Count = new int[26];

        // we count every character we seen in length of s1 string
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // use matches for counting match character
        int matches = 0;
        // initial count match character
        for(int i = 0; i < 26; i++){
            if(s1Count[i] == s2Count[i]){
                matches++;
            }
        }
        System.out.println(matches);
        System.out.println("0" + Arrays.toString(s1Count));
        System.out.println("1" + Arrays.toString(s2Count));

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            System.out.println(r + Arrays.toString(s1Count));
            System.out.println(r + Arrays.toString(s2Count));
            System.out.println(matches);
            if(matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            // add character in window array
            s2Count[index]++;
            // check if s1 character is equal to s2 character
            if(s1Count[index] == s2Count[index]){
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]){ // if it was the same as before but has more character, decrease the matches
                matches--;
            }

            // now we remove the character
            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if(s1Count[index] == s2Count[index]){
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]){
                matches--;
            }

            l++;
        }



        return matches == 26;
    }
}
