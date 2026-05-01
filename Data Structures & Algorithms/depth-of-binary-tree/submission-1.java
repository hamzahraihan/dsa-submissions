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

        return 1 + Math.max(left,right);
    }
}


// intuisi
/*
kita harus turun ke paling dasar dari TreeNode dengan menggunakan cara depth first search atau pencarian treenode secara recursive untuk mendapatkan 
tinggi dari treenode
 */

// algoritma
/*
-pada method maxDepth buatkan base case agar ketika root adalah null maka kembalikan nilai 0
-buat fungsi ekspresi untuk mendapatkan nilai kedalaman dari pada treenode kiri dan kanan  
-lakukan penjumlahan untuk menghitung setiap kali kita bergerak dari node ke node
 */