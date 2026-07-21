class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, res, subset, nums);
        return res;
    }

    private void backtrack(int i, List<List<Integer>> res, List<Integer> subset, int[] nums){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, res, subset, nums);
        subset.remove(subset.size() - 1);
        backtrack(i + 1, res, subset, nums);
    }
}
