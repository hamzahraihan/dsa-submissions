class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, res, new ArrayList<String>());
        return res;
    }

    private void backtrack(int i, String s, List<List<String>> res, List<String> part){
        if(i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                part.add(s.substring(i, j + 1));
                backtrack(j + 1, s, res, part);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}
