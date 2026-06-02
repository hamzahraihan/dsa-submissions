class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, nums, res, subset);

        return res;
    }

    private void backtrack(int i,int[] nums, List<List<Integer>> res, List<Integer> subset){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, nums, res, subset);
        subset.remove(subset.size() - 1);
        backtrack(i + 1, nums, res, subset);
    }
}
