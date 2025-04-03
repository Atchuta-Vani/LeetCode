/**
Base Case: If start Index is greater than endIndex, return null.

Recursive Case:
    The first element in preorder is the root of the current subtree.
    Find the index of the root in inorder.
    Elements to the left of this index in inorder form the left subtree, and elements to the right form the right subtree.
    Recursively build the left and right subtrees using the corresponding slices of the preorder and inorder arrays.

 */

//105. Construct Binary Tree from Preorder and Inorder Traversal
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
    Map<Integer,Integer> inorderMap = new HashMap();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        
        return build(preorder, 0,preorder.length-1);
    }
    public TreeNode build(int[] preorder, int inStart,int inEnd){
        
        if(inStart > inEnd){
            return null;
        }
        System.out.println("inStart "+inStart+"inEnd "+inEnd);
        int rootValue = preorder[preIndex++];
        int rootIndex = inorderMap.get(rootValue);
        TreeNode rootNode = new TreeNode(rootValue);

        rootNode.left = build(preorder,inStart,rootIndex-1);
        rootNode.right = build(preorder,rootIndex+1,inEnd);

        return rootNode;
    }
}
