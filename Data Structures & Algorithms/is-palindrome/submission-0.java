class Solution {
    public boolean isPalindrome(String s) {
        String nopunc = s.replaceAll("\\p{Punct}", "")
                            .replaceAll("\\s+", "")
                            .toLowerCase().trim();
        String rword = new StringBuilder(nopunc).reverse().toString();

        return rword.equals(nopunc);
    }
}
