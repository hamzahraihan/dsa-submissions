class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> container = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;

            if(container.containsKey(diff)){
                return new int[] {container.get(diff), i};
            }

            container.put(num,i);
        }
        return new int[] {};
    }
}
