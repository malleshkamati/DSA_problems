package DSA_problems.Trees;

public class MaxDepthDemo {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MaxDepthDemo demo = new MaxDepthDemo();
        int depth = demo.maxDepth(root);
        System.out.println("Max depth  " + depth);
    }

    public int maxDepth(TreeNode root){
       if(root==null){
           return 0;
       }

       return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
