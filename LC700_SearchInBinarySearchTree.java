//700. Search in a Binary Search Tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        if(root == null)
            return null;
        if(root.val == val){
            return root;
        }
        if(val<root.val){
             node = searchBST(root.left, val);
        }
        if(val > root.val){
             node = searchBST(root.right, val);
        }
        return node;
        
    }
}
