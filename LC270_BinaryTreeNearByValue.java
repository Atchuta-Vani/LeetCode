package LC;

public class LC270_BinaryTreeNearByValue {
        int closestValue;
        double minValue = Integer.MAX_VALUE;

        public static void main(String[] args){
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            LC270_BinaryTreeNearByValue solution = new LC270_BinaryTreeNearByValue();
            int result = solution.closestValue(root, 3.714);
            System.out.println(result);
        }

        public int closestValue(TreeNode root, double target) {
            closestValue = root.val;
            return dfs(root,target);
        }

        public int dfs(TreeNode root, double target) {
            if(root == null){
                return closestValue;
            }
            double currentDistance = Math.abs(target - root.val);
            if(minValue > currentDistance){
                minValue = currentDistance;
                closestValue = Math.min(closestValue,root.val);
            }
            else if(minValue == currentDistance){
                closestValue = Math.min(closestValue,root.val);
            }
            if(target < root.val){
                dfs(root.left,target);
            }
            if(target > root.val){
                dfs(root.right,target);
            }
            return closestValue;
        }
}
