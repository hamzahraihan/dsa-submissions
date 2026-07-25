class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] sorted = new int[nums.length][2]; 
        for(int i = 0; i < nums.length; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int sums = sorted[l][0] + sorted[r][0];
            if(sums > target){
                r--;
            } else if (sums < target){
                l++;
            } else {
                return new int[] {Math.min(sorted[l][1], sorted[r][1]), Math.max(sorted[l][1], sorted[r][1])};
            }
        }
        return new int[0];
    }
}
