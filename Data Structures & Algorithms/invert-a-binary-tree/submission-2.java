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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }
}

/* 
- intuisi:
untuk membuat nilai pada binary tree terbalik, gunakan cara recursive depth first search untuk mencari node paling bawah
lalu tukar node kiri menjadi kanan dan sebaliknya 
*/

/* 
algoritma: 
- buat base case agar bisa backtrack ke node sebelumnya
- buat variable temp untuk menyimpan nilai kiri
- tukar node kanan menjadi temp dan node kiri menjadi kanan 
- buat recursive untuk menjadi node root kiri dan kanan
- kembalikan node root
*/
