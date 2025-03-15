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
 // 98. Validate Binary Search Tree. 
 // validating left and right child with root is not enough. we need to check at every level.  
class Solution {
    public boolean isValidBST(TreeNode root) {
        long lowerBound = Long.MIN_VALUE;
        long upperBound = Long.MAX_VALUE;

        if(root == null)
            return true;
        return dfs(root, lowerBound, upperBound);
    }

    public boolean dfs(TreeNode node, long lowerBound, long upperBound){
        if(node == null){
            return true;
        }
        if(node.val <= lowerBound || node.val >= upperBound){
                return false;
        }
        return dfs(node.left,lowerBound, node.val) && dfs(node.right, node.val, upperBound);
    }
    
}
