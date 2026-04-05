class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(unique.contains(nums[i])){
                return nums[i];
            }
            unique.add(nums[i]);
        }
        return 0;
    }
}
