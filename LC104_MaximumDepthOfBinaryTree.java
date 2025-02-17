//104. Maximum Depth of Binary Tree
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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {

    return height(root);    

    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH,rightH)+1;
    }
}
