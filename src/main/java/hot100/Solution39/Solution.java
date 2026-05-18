package hot100.Solution39;

import hot100.Solution36.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return isSymmetric2(root.left, root.right);
    }

    public boolean isSymmetric2(TreeNode rootl, TreeNode rootr) {
        if (rootl == null && rootr == null) return true;
        if (rootl == null || rootr == null) return false;
        return rootl.val == rootr.val && isSymmetric2(rootl.left, rootr.right) && isSymmetric2(rootl.right, rootr.left);
    }
}