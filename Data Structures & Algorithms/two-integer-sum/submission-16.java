class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] sortedNums = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }

        Arrays.sort(sortedNums, (a, b) -> a[0] - b[0]);
        int l = 0, r = nums.length - 1;
        while(l < r){
            int sums = sortedNums[l][0] + sortedNums[r][0];
            System.out.println(sums);
            if(sums < target){
                l++;
            } else if(sums > target){
                r--;
            } else {
                if(sortedNums[l][1] < sortedNums[r][1]){
                    return new int[] {sortedNums[l][1], sortedNums[r][1]};
                }
                return new int[] {sortedNums[r][1], sortedNums[l][1]};
            }
        }

        return new int[0];
    }
}
