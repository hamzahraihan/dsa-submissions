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
        if(p == null && q == null) return true; // we want to return true if both reaching null node

        if(p != null && q != null && p.val == q.val){ // in every iterations, we check if node both node has value, and have equal value
            return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);// then we check if both node is true, otherwise it has different structure
        }
        // return false if both structure is different
        return false;
    }
}
