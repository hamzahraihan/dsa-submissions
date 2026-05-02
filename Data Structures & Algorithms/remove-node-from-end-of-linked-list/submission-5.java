/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;

        while(curr != null){
            length++;
            curr = curr.next;
        }

        int target = length - n;
        if(target == 0){
            return head.next;
        }

        curr = head;
        for(int i = 0; i < target - 1; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        
        return head;
    }
}
