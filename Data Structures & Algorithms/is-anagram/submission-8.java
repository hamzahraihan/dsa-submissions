class Solution {
    public boolean isAnagram(String s, String t) {
        char[] tchars = t.toCharArray();
        char[] schars = s.toCharArray();
        Arrays.sort(tchars);
        Arrays.sort(schars);
        String tsorted = new String(tchars);
        String ssorted = new String(schars);
        return ssorted.equals(tsorted);
    }
}
