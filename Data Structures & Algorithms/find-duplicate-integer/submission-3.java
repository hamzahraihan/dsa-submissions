// using O(n) time
// using O(1) space
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow]; // move 1 step
            fast = nums[nums[fast]]; // move 2 step
            if(slow == fast){
                break;
            }
        }
        int pointerA = nums[0];
        int pointerB = fast;
        while(pointerA != pointerB){
            pointerA = nums[pointerA];
            pointerB = nums[pointerB];
        }
       
        return pointerB;
    }

}
