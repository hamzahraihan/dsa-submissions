/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        // jika root node tidak memiliki leaf node maka kembalikan nilai true
        if(p == null && q == null){
            return true;
        }


        if(p != null && q != null && p.val == q.val){
            // telusuri binary tree node kiri
            boolean left = isSameTree(p.left, q.left);
            // telusuri binary tree node kanan
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        }
        return false;
    }
}

// intuisi
/* 
untuk melihat apakah struktur data binary trees ini memiliki cabang dan nilai yang sama satu dengan lain
kita bisa menggunakan cara recursion yaitu memanggil method di dalam method. recursion ini berguna untuk mencari
bagian paling dalam dari binary tree.

kita bisa gunakan cara tersebut untuk menjelajahi cabang kanan dan kiri
*/

/* algoritma
buat base case yaitu jika binary tree p dan q sama sama tidak mempunyai nilai maka kembalikan nilai true 
lalu buat variable left dan right 
cek jika p dan q tidak null, dan p dan q memiliki nilai yang sama, maka kita buatkan;
    - variable left dengan recursion untuk menjelajahi cabang bagian kiri
    - variable right dengan recursion untuk menjelajahi cabang bagian kanan
kembalikan salah satu variable yang memiliki nilai true pada left atau right dengan cek menggunakan kondisi or (||)
jika kondisi tidak tercapai, maka kembalikan nilai false
*/


