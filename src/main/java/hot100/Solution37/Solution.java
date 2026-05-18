package hot100.Solution37;

import hot100.Solution36.TreeNode;

public class Solution {

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (maxDepth < depth) maxDepth = depth;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

}