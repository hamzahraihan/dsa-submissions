class Solution {
    Map<Integer, Integer> count = new HashMap<>(); 
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> uniqueNums = new ArrayList<>();
        for(int num : nums){
            if(!count.containsKey(num)){
                uniqueNums.add(num);
            }
            count.put(num, count.getOrDefault(num,0) + 1);
        }
        backtrack(0, nums, new ArrayList<>(), uniqueNums);
        return res;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset, List<Integer> uniqueNums){
        if(i == uniqueNums.size()){
            res.add(new ArrayList<>(subset));
            return;
        }

        int currentNum = uniqueNums.get(i);
        int freq = count.get(currentNum);

        for(int k = 0; k <= freq; k++){
            for(int j = 0; j < k; j++){
                subset.add(currentNum);
            }

            backtrack(i + 1, nums, subset, uniqueNums);

            for(int j = 0; j < k; j++){
                subset.remove(subset.size() - 1);
            }
        }
    }
}
