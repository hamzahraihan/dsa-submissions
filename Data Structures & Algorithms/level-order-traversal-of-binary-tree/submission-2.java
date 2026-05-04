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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0, res);
        return res;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> res){
        // buatkan base case jika node adalah null maka kembali ke node sebelumnya
        if(node == null) return;
        
        // buatkan kondisi jika ukuran res sama dengan kedalaman node, maka buatkan list kosong didalam list res
        if(res.size() == depth){
            res.add(new ArrayList<>());
        }

        // simpan nilai node left dan right berdasarkan kedalaman
        res.get(depth).add(node.val);
        // telusuri node kanan dan kiri
        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}

//intuisi
/* 
masukkan masing masing node berdasarkan kedalaman pada root
buatkan list untuk menyimpan nilai pada node
*/


// algoritma
/* 
- buatkan list dalam list dengan tipe data integer untuk menyimpan nilai pada seluruh node
- buatkan fungsi dfs untuk menelusuri setiap node 
- didalam fungsi dfs buat base case ketika node mencapai null maka kembali ke node sebelumnya
- setiap panjang dari list sama dengan kedalaman, maka buatkan list kosong untuk menyimpan nilai node pada kedalaman tersebut
- untuk menelusuri setiap node, buatkan dfs khusus node kanan dan kiri
*/
