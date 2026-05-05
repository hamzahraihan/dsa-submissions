/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> deepCopy = new HashMap<>();
        deepCopy.put(null,null);

        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            deepCopy.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = deepCopy.get(curr);
            copy.next = deepCopy.get(curr.next);
            copy.random = deepCopy.get(curr.random);
            curr = curr.next;
        }

        return deepCopy.get(head);
    }
}
