class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Map<Integer, Integer> count = new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> A = new ArrayList<>();
        for(int can : candidates){
            if(!count.containsKey(can)){
                A.add(can);
            }
            count.put(can, count.getOrDefault(can, 0) + 1);
        }
        dfs(A, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(List<Integer> nums, int target, int i, List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || i >= nums.size()){
            return;
        }
        if(count.get(nums.get(i)) > 0){
            curr.add(nums.get(i));
            count.put(nums.get(i), count.get(nums.get(i)) - 1);
            dfs(nums, target - nums.get(i), i, curr);
            count.put(nums.get(i), count.get(nums.get(i)) + 1);
            curr.remove(curr.size() - 1);
        }
        dfs(nums, target, i + 1, curr);
    }
}
