class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int l = 0, r = 0;
        while(r < nums.length){
            if(r - l > k){
                seen.remove(nums[l]);
                l++;
            }
            if(seen.contains(nums[r])){
                return true;
            }
            seen.add(nums[r]);
            r++;
        }
        return false;
    }
}