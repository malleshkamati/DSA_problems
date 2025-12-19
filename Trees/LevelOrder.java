package DSA_problems.Trees;

import java.util.*;

// Given the root of a binary tree, return the level order traversal of its nodes' values. 
// (i.e., from left to right, level by level).
public class LevelOrder {
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;

        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> lst=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();

                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
                lst.add(temp.val);

            }
            ans.add(lst);

            
        }

        return ans;
    }

    public static void main(String[] args) {
        
        TreeNode head=new TreeNode(10);
        head.left=new TreeNode(1);
        head.right=new TreeNode(2);
        head.left.left=new TreeNode(3);
        head.left.right=new TreeNode(4);

        LevelOrder l=new LevelOrder();
        List<List<Integer>> ans=l.levelOrder(head);
        System.out.println(ans);
    }


}
