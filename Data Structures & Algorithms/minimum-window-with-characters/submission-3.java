class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        // we count the string int "t"
        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // we count the current window
        Map<Character, Integer> window = new HashMap<>();

        // count every char matches with string "t" that we found;
        int have = 0;

        // the numbers of match string that we need
        int need = countT.size();

        // store our shortest window
        int[] res = {-1, -1};

        // store the length of windows 
        int resLen = Integer.MAX_VALUE;

        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            // check if we found the character that we need
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }

            while(have == need){
                // if we found a window that is shorter than before
                // we overwrite it with the shortest one
                if((r - l + 1) < resLen){
                    // store the shortest window
                    resLen = r - l + 1;
                    // store window size as array input 
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                // if we found the same character and its count in window below countT, we decrease current have value
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
                l++;
            }
        }

        // check if we found the string t, if not we return empty string, if we found it, return the substring
        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1); 
    }
}
