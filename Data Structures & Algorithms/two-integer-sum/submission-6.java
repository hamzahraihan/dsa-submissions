class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] renums = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            renums[i][0] = nums[i];
            renums[i][1] = i;
        }
        Arrays.sort(renums, (a , b) -> a[0] - b[0]);
        int left = 0;
        int right = nums.length - 1;
        // for(int[] i : renums ){
        //     for(int e: i){
        //         System.out.println(e);
        //     }
        // }
        while(left < right){
            int sums = renums[left][0] + renums[right][0]; 
            if(sums > target){
                right--;
            }else if(sums < target){
                left++;
            }else {
                return new int[] {Math.min(renums[left][1],renums[right][1])
                ,Math.max(renums[left][1],renums[right][1])};
            }
        }
        return new int[]{};
    }
}
