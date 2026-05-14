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
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth){
        if(node == null) return;

        // if we are in the specific depth we create an empty array list to store node value
        if(depth == res.size()){  
            res.add(new ArrayList());
        }

        // insert node val to res list each time we travel the node 
        res.get(depth).add(node.val);

        // travel to right node, and left node
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}

