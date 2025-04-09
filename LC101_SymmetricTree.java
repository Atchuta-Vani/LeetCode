
/**
Compare left and right subtrees.

They must be mirror images:

left.val == right.val

left.left should mirror right.right

left.right should mirror right.left
 */ 
 //101. Symmetric Tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root.left,root.right);
        
    }
    public boolean checkSymmetry(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return checkSymmetry(left.left,right.right) && checkSymmetry(left.right,right.left);
    }
}
