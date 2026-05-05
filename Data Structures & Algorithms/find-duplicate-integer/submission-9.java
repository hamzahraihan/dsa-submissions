class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int l = 0;
        for(int r = 0; r < nums.length;r++){
            int count = 0;
            while(seen.contains(nums[r])){
                seen.remove(nums[l]);
                return nums[r];
            }
            seen.add(nums[r]);
        }
        return -1;
    }
}
