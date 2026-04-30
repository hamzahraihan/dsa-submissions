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
        if(root == null){
            // if root is null meaning that root is a leaf, so return it as a balance binary tree
            return new int[]{1,0};
        }

        // search using depth-first to go as deepest until we found the leaf
        int[] left = dfs(root.left);
        int[] right = dfs(root.right); 

        // see if node is balanced or not by checking the left node is balanced and
        // right node is balanced AND left height subtract with right height has value below 1 
        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);

        // store the maximum depth of node
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};

    }
}
