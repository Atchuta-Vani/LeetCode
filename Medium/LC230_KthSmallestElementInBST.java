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

 // 230 Kth Smallest Element in BST
 // O(N)
 // In - order traversal will give sorted Array. then find kth element in array. 
class Solution {
    public List<TreeNode> list = new ArrayList<TreeNode>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);

        if(list.size() >= k){
            return list.get(k-1).val;
        }
        return -1;
    }

    void dfs(TreeNode node){
        if(node == null){
            return;
        }
        
        dfs(node.left);
        list.add(node);
        dfs(node.right);
        
    }

}
