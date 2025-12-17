package DSA_problems.Trees;

public class PreOrder {
    public static void main(String[] args) {
        
        TreeNode head=new TreeNode(10);
        head.left=new TreeNode(1);
        head.right=new TreeNode(2);
        head.left.left=new TreeNode(3);
        head.left.right=new TreeNode(4);
        PreOrder o=new PreOrder();
        o.preorder(head);
    }

    void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        
        preorder(root.right);
    }
}
