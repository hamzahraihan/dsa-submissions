class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // move 1 step
        int fast = nums[0]; // move 2 step

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
            System.out.println(slow + " " + fast);
        }
        // System.out.println(slow + " " + fast);
        return slow;
    }
}
