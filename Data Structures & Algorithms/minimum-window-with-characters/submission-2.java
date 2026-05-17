class Solution {
    public String minWindow(String s, String t) {
        // edge case, if string "t" is empty we return empty string
        if(t.isEmpty()) return "";

        // count the unique string in "t"
        Map<Character, Integer> countT = new HashMap<>();

        // count the current window 
        Map<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // count string matches with string "t" we found
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
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                // character in the window is equal to the we need, add count by 1
                have++;
            }

            // while we met the characters that we need
            while(have == need){
                if((r - l + 1) < resLen){
                    resLen =  r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
                l++;
            }
        }
        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}
