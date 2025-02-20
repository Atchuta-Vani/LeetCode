/**
Approach: DFS
Steps:

Start from the given node.
If the node has been cloned already, return the cloned node.
Otherwise, create a new node, clone its neighbors recursively, and update the map.
Time Complexity: O(N+E)// Every node is visited twice, one for its own copy and other for neighbors.
Space Complexity: O(N);
*/

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
        Map<Node,Node> map = new HashMap<Node,Node>();


        if(node == null){
            return null;
        }
        return dfs(node,map);
    }

    public Node dfs(Node node, Map<Node, Node> map){
        if(map.containsKey(node)){
            return (Node)map.get(node);
        }
        Node cloneNode = new Node();

            cloneNode = new Node(node.val);
            map.put(node,cloneNode);

            for(Node n: node.neighbors){
                    cloneNode.neighbors.add(dfs(n,map));
                }

        
        return cloneNode;

    }
}
