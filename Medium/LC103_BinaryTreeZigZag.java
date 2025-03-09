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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            //System.out.println("size "+size);

            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node != null){
                    list.add(node.val);
                        
                        if(node.left != null)                            
                            q.offer(node.left);
                        if(node.right != null)
                            q.offer(node.right);    
                }
            }
            if(flag){
                Collections.reverse(list);
                result.add(list);
            }else{
                result.add(list);
            }
            flag = !flag;
            //System.out.println("list "+list+"flag "+flag);
            
            
        }

        //System.out.println(result);
        return result;
    }
}
