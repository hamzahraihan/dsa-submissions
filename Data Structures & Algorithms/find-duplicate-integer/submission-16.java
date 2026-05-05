class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        int pointerA = 0, pointerB = fast;
        while(pointerA != pointerB){
            pointerA = nums[pointerA];
            pointerB = nums[pointerB];
        }
        return pointerA;
    }
}
