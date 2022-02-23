/*
// Definition for a Node.
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
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>(); 
        map.put(node, new Node(node.val));
        queue.addLast(node);
        while (queue.size() > 0) {
            Node currNode = queue.removeFirst();             
            for (Node currNeighbor : currNode.neighbors) {
                if (!map.containsKey(currNeighbor)) {
                    map.put(currNeighbor, new Node(currNeighbor.val)); 
                    queue.addLast(currNeighbor);          
                }
                map.get(currNode).neighbors.add(map.get(currNeighbor));      
            }
        }
        return map.get(node);
    }
}