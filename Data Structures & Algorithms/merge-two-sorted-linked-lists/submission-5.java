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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head;  
        if(list1.val < list2.val){
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }


        ListNode current = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;
        return head;
    }
}
// intuisi
/* 
untuk menyatukan linkedlist list1 dan list2 sesuai urutan berdasarkan nilai, kita bisa membuat linkedlist baru
cari linkedlist dengan nilai paling rendah sebagai head
lalu jika linkedlist list1 dan list2 belum mencapai nilai null maka 
bandingkan kedua nilai list1 dan list2
jika nilai list1 memiliki nilai lebih rendah dari nilai list2 maka masukkan nilai list1, dan sebaliknya
jika salah satu linkedlist masih memiliki node tersisa maka kembalikan node sisa tersebut ke linkedlist baru
*/

// algorima
/* 
- buat kondisi untuk cek apakah list1 memiliki nilai null, jika iya maka kembalikan list2, dan sebaliknya
- buat listnode head untuk menyimpan nilai paling rendah sebagai nilai awal
- buat variable current untuk linkedlist yang akan dimerge dan berurut 
- buat while loop dengan kondisi jika list1 dan list2 tidak null
- didalam loop buat kondisi jika list1 lebih rendah dari list2 maka simpan node list1 didalam listnode current, dan sebaliknya
- jika salah satu dari linkedlist memiliki node tersisa, kita bisa simpan sisanya kedalam linkedlist baru
- kembalikan linkedlist head
*/