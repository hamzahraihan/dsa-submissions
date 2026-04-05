class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // create an array to represent an alphabet
        // index 0 == 'A' so index 25 == 'Z' 
        int[] alphabet = new int[26];

        // scan an alphabet each string
        for(int i = 0; i < s.length(); i++ ){ // n loop
            // each alphabets has ascii number
            // example: a == 97, so 97 - 97 is 0
            // this means a is in array of index 0
            alphabet[s.charAt(i) - 97]++;
            alphabet[t.charAt(i) - 97]--;
        }

        for(int i : alphabet){
            if(i > 0 || i < 0){
                return false;
            }
        }
        return true;
        
   }
}
