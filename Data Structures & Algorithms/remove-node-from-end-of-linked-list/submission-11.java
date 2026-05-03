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
     
        curr = head;
        int target = length - n;
        if(target == 0){
            return head.next;
        }
        for(int i = 0; i < target - 1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}

// intuisi:
/*
cari panjang dari linked list, untuk mencari node n dari node terakhir
misal kita mempunyai node dengan nilai [1, 2, 3, 4]
kita mengetahui bahwa panjang dari node adalah 4 lalu kurangi dengan n 
misal n adalah 2 maka target kita adalah 2 karena 4 - 2
maka kita bisa menggunakan hasil tersebut sebagai target
 */

// algoritma
/* 
- buat variable length untuk menyimpan hasil panjang dari linkedlist
- hitung panjang node menggunakan while loop
- cari target node terakhir dari n dengan cara hitung panjang lalu kurangi dengan n
- jika target memiliki nilai 0 maka kembalikan node selanjutnya
- buat loop untuk menggerakkan linked list berdasarkan nilai target
- skip node target
- kembalikan nilai head
*/
