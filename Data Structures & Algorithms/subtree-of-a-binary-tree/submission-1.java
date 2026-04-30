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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(sameTree(root, subRoot)){
            return true;
        }

        // we going to the depth of each node from left to right
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot){
        // if both root and subroot reaching leaf node, we then return true.
        // meaning that root has same tree as subRoot
        if(root == null && subRoot == null){
            return true;
        }

        // we checking each root and subroot if it is not null and has the same value for each other
        // then we can continue
        if(root != null && subRoot != null && root.val == subRoot.val){
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }
        return false;
    }
}
