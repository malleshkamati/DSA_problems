package DSA_problems.Trees;



public class BalancedTreeCheck {

   public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
      root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right=new TreeNode(5);
       root.right.right = new TreeNode(6);

     BalancedTreeCheck checker=new BalancedTreeCheck();
    boolean result=checker.isBalanced(root);
     System.out.println("Is the tree balanced? " + result);

     TreeNode unbalancedRoot = new TreeNode(1);
     unbalancedRoot.left=new TreeNode(2);
    unbalancedRoot.left.left = new TreeNode(3);

     boolean result2 = checker.isBalanced(unbalancedRoot);
     System.out.println("Is the second tree balanced? "+result2);
   }

    public boolean isBalanced(TreeNode root){
      return dfsheight(root) != -1;
    }

   private int dfsheight(TreeNode root){
       if(root==null)
         return 0;

       int left=dfsheight(root.left);
        int right = dfsheight(root.right);

      if(left==-1 || right==-1){
       return -1;
     }

     if(Math.abs(left-right)>1)
        return -1;

      return 1+Math.max(left,right);

   }
}
