package DSA_problems.Trees;

import java.util.*;
// Given the root of a binary tree, invert the tree, and return its root.


public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){return root;}
        
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode ref=root;
        q.offer(root);

        while(!q.isEmpty()){

            TreeNode temp=q.poll();

            TreeNode temp1=temp.left;
            temp.left=temp.right;
            temp.right=temp1;
            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
        }

        return ref;
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(10);
        head.left=new TreeNode(1);
        head.right=new TreeNode(2);
        head.left.left=new TreeNode(3);
        head.left.right=new TreeNode(4);

        InvertTree obj=new InvertTree();
        TreeNode p=obj.invertTree(head);
        System.out.println(p.left.val);
        System.out.println(p.right.val);

    }
}
