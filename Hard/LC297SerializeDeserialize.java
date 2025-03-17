/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
Serializing: 
    Use StringBuffer(not list)
    use DFS Pre Order.
Deserializing: 
    Use Q to create tree nodes. Do not add first element to the queue, directly send q to deserializeHelper.
    return null.
297 Serialize Deserialize Binary Tree.
*/

public class Codec {
    List<Integer> result = new ArrayList();
    StringBuffer sb = new StringBuffer();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        dfs(root);
        //System.out.println(result);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        String[] array = data.split(",");
        //System.out.println("array "+Arrays.asList(array));
        Queue<String> queue = new LinkedList(Arrays.asList(array));
        
// NO need to get first element here. send the Queue as is to deserializeHelper.
        return deserializeHelper(queue);
    }
public TreeNode deserializeHelper(Queue<String> queue){
    String val = queue.poll();
    if(val.equals("null")){
        return null;
    }
    TreeNode node = new TreeNode();
    node.val = Integer.parseInt(val);
    node.left = deserializeHelper(queue);
    node.right = deserializeHelper(queue);
    return node;
}


    public void dfs(TreeNode node){
        if(node == null){   
            sb.append("null"+",");         
            return;
        }
        sb.append(node.val+",");
        dfs(node.left);
        dfs(node.right);        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
