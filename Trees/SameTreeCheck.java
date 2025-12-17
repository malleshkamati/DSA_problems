package DSA_problems.Trees;
// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally 
// identical, and the nodes have the same value.
public class SameTreeCheck {

    public static void main(String[] args) {
        
        TreeNode tree1 = new TreeNode(10);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);

      
        TreeNode tree2 = new TreeNode(10);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);
        tree2.left.left = new TreeNode(3);
        tree2.left.right = new TreeNode(4);

        SameTreeCheck checker = new SameTreeCheck();
        boolean result = checker.isSameTree(tree1, tree2);
        System.out.println("are same " + result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) { // simplified both null checks
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
