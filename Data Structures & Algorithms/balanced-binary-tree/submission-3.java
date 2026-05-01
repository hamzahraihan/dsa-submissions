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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root){
        // base case
        // jika root null maka kembalikan nilai balanced dengan height 0
        if(root == null){
            return new int[]{1,0};
        }

        // cek node kiri dan kanan
        int[] left = dfs(root.left); 
        int[] right = dfs(root.right); 

        // cek apakah node kanan dan kiri merupakan balanced dan left - right <= 1
        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);
        
        // kembalikan nilai 1 jika balanced, dan height dari node
        return new int[]{balanced ? 1 : 0, height};
    }
}

// intuisi
/*
untuk melihat apakah binary merupakan height balanced atau tidak kita bisa 
menggunakan depth first search untuk melihat apakah cabang dari root memiliki perbedaan node tidak lebih dari 1
kita menghitung kedalaman node kanan dan kiri dengan menyimpan tinggi node dan tandai jika node tersebut seimbang atau tidak
untuk cek apakah node seimbang, kita bisa menghitung jika node mempunyai perdebaan tidak lebih dari 1 yaitu dengan mengurangi tinggi node kanan dan node kiri
*/

// algoritma
/*
- buat method dfs dengan parameter TreeNode root untuk mencari tinggi root tersebut
- buat base case pada method dfs jika root node adalah null maka kembalikan nilai array berisi 2 input yaitu balanced ditandai dengan nilai 1, dan tinggi node 
- lalu buat recursion left dan right node dengan mengembalikan nilai array
- cek apakah recursion tersebut balance atau tidak
- jika balanced maka masukkan kedalam array 
- kembalikan nilai array {balanced, height}
*/