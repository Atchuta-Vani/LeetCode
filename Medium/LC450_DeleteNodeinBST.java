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
//450. Delete Node in a BST
 /**
 Algorithm
Search for the node recursively.
If root.val == key, delete it based on:
Case 1: Leaf Node (null left & right) → Return null.
Case 2: One Child (null left OR right) → Return the non-null child.
Case 3: Two Children:
Find the inorder successor (smallest node in the right subtree).
Replace root.val with successor.val.
Recursively delete successor from the right subtree.
Return the modified root.

Time Complexity
O(H) → Height of the tree (O(log N) for balanced, O(N) for skewed).
O(1) Space (excluding recursion stack).
 
  */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return root;
        }
        if(key < root.val) 
            root.left = deleteNode(root.left,key);
        if(key > root.val) 
            root.right = deleteNode(root.right,key);
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            if(root.left != null && root.right != null){                
                int val = findMin(root.right);
                root.val = val;
                root.right = deleteNode(root.right,val);
            }

        }

        return root;

    }
    int findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
        
}
