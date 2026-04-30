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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}

/* 
intuisi:
cari kedalaman yang paling dalam dari binary tree dengan menggunakan dfs
lalu ketika sudah berada pada node paling rendah kita kembalikan nilai satu untuk nantinya ditambahkan lagi seiring backtraking
setelah itu komparasi nilai maksimal antara node kanan dan kiri
lalu kembalikan nilai maxnya
*/

/* 
algoritma:
- buatkan variable left dan right untuk menyimpan point kedalaman pada tree node
- kembalikan nilai maksimal kedalaman

*/