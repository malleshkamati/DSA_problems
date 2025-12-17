package DSA_problems.Trees;

public class PostOrder {
    public static void main(String[] args) {
        
        TreeNode head=new TreeNode(10);
        head.left=new TreeNode(1);
        head.right=new TreeNode(2);
        head.left.left=new TreeNode(3);
        head.left.right=new TreeNode(4);
        PostOrder o=new PostOrder();
        o.postorder(head);
    }

    void postorder(TreeNode root){
        if(root==null){
            return;
        }
        postorder(root.left);
        
        postorder(root.right);
        System.out.println(root.val);
    }
}
