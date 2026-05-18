class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, res, curr, 0);
        return res;
    }

    private void backtrack(int[] nums, int target,List<List<Integer>>  res, List<Integer> curr, int index){
        // if target reach zero, means that we found the combination of numbers that reach target
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // if we are out of bounds, or target is below 0, we shall backtrack
        if(target < 0 || index >= nums.length) return;

        // in every traversal, we input the number[index] into current list
        curr.add(nums[index]);
        // proceed to continue the dfs process, since we dont care about unique numbers, we just continue to use the same number until we can get to the target
        backtrack(nums, target - nums[index], res, curr, index);
        curr.remove(curr.size() - 1);
        backtrack(nums, target, res, curr, index + 1);
    }
}
