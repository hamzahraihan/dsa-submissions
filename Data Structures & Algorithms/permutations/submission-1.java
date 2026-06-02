class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> permute){
        if(permute.size() >= nums.length){
            res.add(new ArrayList<>(permute));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == '.') continue;
            int temp = nums[i];
            nums[i] = '.';
            permute.add(temp);
            backtrack(nums, res, permute);
            nums[i] = temp;
            permute.remove(permute.size() - 1);
        }
    }
}
