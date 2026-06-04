class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> subset){
        if(i == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, nums, res, subset);
        subset.remove(subset.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        backtrack(i + 1, nums, res, subset);
    }
}
