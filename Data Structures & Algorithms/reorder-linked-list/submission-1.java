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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null, current = slow;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode first = head, second = prev;
        while(second.next != null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
