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
/**
Calculate left max and right max
Update a global max (maxSum) with left + node + right (full path through node)
Return node.val + max(left, right) to parent (because path cannot fork upwards)
 */

 //124. Binary Tree Maximum Path Sum
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int leftMax = Math.max(0,dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));

        int currentMax = root.val + leftMax + rightMax; 
        maxSum = Math.max(currentMax, maxSum);

        return root.val + Math.max(leftMax, rightMax);
    }
}
