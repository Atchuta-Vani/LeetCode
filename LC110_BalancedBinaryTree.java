//LC 110. Balanced Binary Tree
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
    public boolean isBalanced(TreeNode root) {
        return height(root) == -1? false:true;    
    }

     public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        if(leftH == -1){
            return -1;
        } 
        int rightH = height(root.right);
        if(rightH == -1){
            return -1;
        } 
        int diff = Math.abs(leftH-rightH);
        int h = Math.max(leftH,rightH)+1;
        return ( diff <= 1 )?h:-1;
    }
}
