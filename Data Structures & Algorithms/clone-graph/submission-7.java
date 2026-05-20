/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        // create a clone map to store each node we traverse using bf search
        Map<Node, Node> clone = new HashMap<>();

        // we do bfs starting with the first node (node.val = 1, node.neighbors == node.val = 2)
        Queue<Node> q = new LinkedList<>();
        // initial duplicate value as our first input 
        clone.put(node, new Node(node.val));
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node nb : curr.neighbors){
                // check if there is no neighbors value
                if(!clone.containsKey(nb)){
                    clone.put(nb, new Node(nb.val));
                    q.offer(nb);
                }
                // insert current clone node with neighbors node 
                clone.get(curr).neighbors.add(clone.get(nb));
            }
        }

        return clone.get(node);
    }
}