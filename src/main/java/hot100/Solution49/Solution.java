package hot100.Solution49;

import hot100.Solution36.TreeNode;

public class Solution {


    public int searchChildren(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 1;
        int ret = 1;
        if (root == p) ret = 2;
        else if (root == q) ret = 3;
        return ret * searchChildren(root.left, p, q) * searchChildren(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode ret = root;
        if (searchChildren(root.left, p, q) == 6) ret = lowestCommonAncestor(root.left, p, q);
        else if (searchChildren(root.right, p, q) == 6) ret = lowestCommonAncestor(root.right, p, q);
        return ret;
    }
}