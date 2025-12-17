package DSA_problems.Trees;
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


public class SymmetricTreeCheck {

    public static void main(String[] args) {
        // Example symmetric tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTreeCheck checker = new SymmetricTreeCheck();
        boolean result = checker.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root.left, root.right);
    }

    public boolean isValid(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isValid(t1.left, t2.right) && isValid(t1.right, t2.left);
    }
}
