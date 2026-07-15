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
    private static class BfsResult {
        TreeNode node;
        int distance;

        BfsResult(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        BfsResult firstPass = getFurthestNode(root, parentMap);
        TreeNode nodeA = firstPass.node;

        BfsResult secondPass = getFurthestNode(nodeA, parentMap);

        return secondPass.distance;
    }

    private void buildParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node == null)
            return;
        if (node.left != null) {
            parentMap.put(node.left, node);
            buildParentMap(node.left, parentMap);
        }

        if (node.right != null) {
            parentMap.put(node.right, node);
            buildParentMap(node.right, parentMap);
        }
    }

    private BfsResult getFurthestNode(TreeNode startNode, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        nodeQueue.add(startNode);
        distanceQueue.add(0);
        visited.add(startNode);

        TreeNode furthestNode = startNode;
        int maxDistance = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            int currentDistance = distanceQueue.poll();

            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                furthestNode = current;
            }

            // Gather all neighbors (Left, Right, Parent)
            List<TreeNode> neighbors = new ArrayList<>();
            if (current.left != null)
                neighbors.add(current.left);
            if (current.right != null)
                neighbors.add(current.right);
            if (parentMap.containsKey(current))
                neighbors.add(parentMap.get(current));

            // Queue unvisited neighbors
            for (TreeNode neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    nodeQueue.add(neighbor);
                    distanceQueue.add(currentDistance + 1);
                }
            }
        }

        return new BfsResult(furthestNode, maxDistance);
    }
}
