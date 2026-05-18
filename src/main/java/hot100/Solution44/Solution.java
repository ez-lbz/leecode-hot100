package hot100.Solution44;

import hot100.Solution36.TreeNode;

public class Solution {
    public int num;
    public int target;

    public int kthSmallest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return target;
    }

    public void dfs(TreeNode root) {
        if (root == null || num <= 0) return;
        dfs(root.left);
        num --;
        if (num == 0) {
            target = root.val;
            return;
        }
        dfs(root.right);
    }
}