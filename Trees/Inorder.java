package DSA_problems.Trees;

public class Inorder {
    
    public static void main(String[] args) {
        
        TreeNode head=new TreeNode(10);
        head.left=new TreeNode(1);
        head.right=new TreeNode(2);
        head.left.left=new TreeNode(3);
        head.left.right=new TreeNode(4);
        Inorder o=new Inorder();
        o.inorder(head);
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
