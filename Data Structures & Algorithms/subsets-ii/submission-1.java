class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        backtrack(0, nums, res, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(int i, int[] nums, Set<List<Integer>> res, List<Integer> subset){
        if(i == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, nums, res, subset);
        subset.remove(subset.size() - 1);
        backtrack(i + 1, nums, res, subset);
    }
}
