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
        head = rec(head, head.next);
    }

    private ListNode rec(ListNode root, ListNode curr) {
        if(curr == null){
            return root;
        }

        root = rec(root, curr.next);
        if(root == null){
            return null;
        }

        ListNode temp = null;
        if(root == curr || root.next == curr){
            curr.next = null;
        } else { 
            temp = root.next;
            root.next = curr;
            curr.next = temp;
        }

        return temp;
    }
}
